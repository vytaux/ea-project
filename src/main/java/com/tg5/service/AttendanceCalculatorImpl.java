package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.AccountRepository;
import com.tg5.repository.EventRepository;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttendanceCalculatorImpl implements AttendanceCalculator {
    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;
    private final RecordRepository recordRepository;
    private final AccountRepository accountRepository;

    @Override
    public double calculateAttendancePerMemberForEvent(Long memberId, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        int totalSessions = event.getSessions().size();
        int totalAttendance = recordRepository.countByEventAndMember(member, event);
        return ((double) totalAttendance / totalSessions) * 100;
    }

    @Override
    public Map<String, Double> calculateAttendancePerMemberForAllAccount(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        Map<String, Double> attendances = new HashMap<>();
        List<Event> events = eventRepository.findAllEventsByMemberId(memberId);
        for (Event event : events) {
            AccountType accountType = event.getAccountType();
            if (!Objects.isNull(event)) {
                int totalSessions = event.getSessions().size();
                int totalAttendance = recordRepository.countByEventAndMember(member, event);
                attendances.put(accountType.getName(), ((double) totalAttendance / totalSessions) * 100);
            }
        }
        return attendances;
    }
}
