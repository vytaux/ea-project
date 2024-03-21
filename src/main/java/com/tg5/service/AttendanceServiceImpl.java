package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.MemberRepository;
import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    private final RecordRepository recordRepository;

    @Override
    public Map<String, Double> getAttendanceByEventId(Long eventId) {
        Map<String, Double> members = new HashMap<>();
        // get event by id
        Event event = eventRepository.findById(eventId).orElseThrow();
        int total = event.getSessions().size();
        for (Member mem : event.getMembers()) {
            int memberSession = recordRepository.countByEventAndMember(mem, event);
            Double calculatedPercentage = ((double) memberSession / total) * 100;
            members.put(mem.getFirstname(), calculatedPercentage);
        }
        return members;
    }

    @Override
    public Map<String, Double> getAttendancePerMemberForAllAccount(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Map<String, Double> attendances = new HashMap<>();
        List<Event> events = eventRepository.findAllEventsByMemberId(memberId);
        for (Event event : events) {
            AccountType accountType = event.getAccountType();
            int totalSessions = event.getSessions().size();
            int totalAttendance = recordRepository.countByEventAndMember(member, event);
            attendances.put(accountType.getName(), ((double) totalAttendance / totalSessions) * 100);
        }
        return attendances;
    }

    @Override
    public double calculateAttendancePerMemberForEvent(Long memberId, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        int totalSessions = event.getSessions().size();
        int totalAttendance = recordRepository.countByEventAndMember(member, event);
        return ((double) totalAttendance / totalSessions) * 100;
    }

    @Override
    public AttendanceByAccountTypeByDateFromToReport getAttendanceByAccountTypeByDateFromTo(
            String accountType,
            String fromDate,
            String toDate
    ) {
        LocalDateTime from = LocalDate.parse(fromDate).atTime(0, 0);
        LocalDateTime to = LocalDate.parse(toDate).atTime(23, 59, 59);

        AttendanceByAccountTypeByDateFromToReport response =
                new AttendanceByAccountTypeByDateFromToReport();

        response.setAccountType(accountType);
        response.setFromDate(from);
        response.setToDate(to);

        List<Event> events = eventRepository.getByAccountTypeAndDateFromTo(accountType, from, to);

        for (Event event : events) {
            int eventSessionsCount = event.getSessions().size();
            for (Member member : event.getMembers()) {
                int userSessionsCount = recordRepository.getCountByEventAndMember(event, member);
                response.getAttendancePercent().put(
                        member.getFullName(),
                        ((double) userSessionsCount / eventSessionsCount) * 100
                );
            }
        }

        return response;
    }
}
