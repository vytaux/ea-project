package com.tg5.service;

import com.tg5.domain.Account;
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
        //TODO! assume that there is one record per session
        int totalAttendance = recordRepository.countByEventAndMember(member, event);
        return ((double) totalAttendance / totalSessions) * 100;
    }

    @Override
    public Map<Long, Double> calculateAttendancePerMemberForAllAccount(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Account> accounts = accountRepository.findAccountsByMember(member);
        Map<Long, Double> attendances = new HashMap<>();
        for(Account account: accounts) {
            AccountType accountType = account.getType();
            // TODO: assumed member has registered for all accounts
           Event event = eventRepository.findEventByAccountType(accountType);
           if (!Objects.isNull(event)) {
               int totalSessions = event.getSessions().size();
               int totalAttendance = recordRepository.countByEventAndMember(member, event);
               attendances.put(account.getId(), ((double) totalAttendance / totalSessions) * 100);
           }
        }
        return attendances;
    }
}
