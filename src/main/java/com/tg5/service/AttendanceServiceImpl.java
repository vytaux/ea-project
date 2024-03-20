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


@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService{

    private final MemberRepository memberRepository;
    private final RecordRepository recordRepository;
    private final AccountRepository accountRepository;
    private final EventRepository eventRepository;


    @Override
    public Map<Long, Double> calculateAttendancePerMemberForEachAccount(Long memberId) {

        Map<Long, Double> attendancePerAccount = new HashMap<>();

        Member member = memberRepository.findById(memberId).orElseThrow();
        List<Account> accounts = accountRepository.findAccountsByMember_Id(memberId);

        for(Account account: accounts) {
            AccountType accountType = account.getType();
            Event event =  eventRepository.getEventByAccountType_Id(accountType.getId());
            int total = event.getSessions().size();

            int countPerEvent = recordRepository.countByEventAndMember(member, event);
            attendancePerAccount.put(account.getId(), ((double) countPerEvent/total)*100);
        }
        return attendancePerAccount;
    }
}



