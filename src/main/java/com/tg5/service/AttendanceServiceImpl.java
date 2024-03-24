package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.reports.AttendanceByAccountTypeAndWithinIntervalReport;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final MemberRepository memberRepository;
    private final EventRepository eventRepository;
    private final RecordRepository recordRepository;
    private final SessionRepository sessionRepository;

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
    public Map<String, Double> calculateAttendancePerMemberForEvent(Long memberId, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        int totalSessions = event.getSessions().size();
        int totalAttendance = recordRepository.countByEventAndMember(member, event);
        return Map.of(member.getFullName(), ((double) totalAttendance / totalSessions) * 100);
    }

    @Override
    public AttendanceByAccountTypeAndWithinIntervalReport getAttendanceByAccountTypeByDateFromTo(
            String accountType,
            LocalDate fromDate,
            LocalDate toDate
    ) {
        AttendanceByAccountTypeAndWithinIntervalReport response =
                new AttendanceByAccountTypeAndWithinIntervalReport();

        response.setAccountType(accountType);
        response.setFromDate(fromDate);
        response.setToDate(toDate);

        LocalDateTime fromDateTime = fromDate.atTime(0, 0, 0);
        LocalDateTime toDateTime = toDate.atTime(23, 59, 59);

        /*
          *** Algorithm ***
          get r.s.e.member from r where start < r.start and r.end < end && r.s.e.type = type
          for each eligible member
              get sessions count - limit by interval, type
              get actual records count - limit by interval, type
          *****************
         */

        List<Member> members = memberRepository
                .getByEventAccountTypeAndScanDateTimeBetween(accountType, fromDateTime, toDateTime);

        for (Member member : members) {
            int totalSessions = sessionRepository
                    .countByMemberAndAccountTypeAndStartEndTimeBetween(member, accountType, fromDateTime, toDateTime);
            int totalAttendance = recordRepository
                    .countByMemberAndAccountTypeAndScanDateTimeBetween(member, accountType, fromDateTime, toDateTime);
            double percentage = ((double) totalAttendance / totalSessions) * 100;
            response.getAttendancePercentage().put(member.getFullName(), percentage);
        }

        return response;
    }
}
