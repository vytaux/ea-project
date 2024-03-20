package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.EventRepository;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceCalculatorImpl implements AttendanceCalculator {
    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;
    private final RecordRepository recordRepository;

    @Override
    public double calculateAttendancePerMemberForEvent(Long memberId, Long eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();
        int totalSessions = event.getSessions().size();
        //TODO! assume that there is one record per session
        int totalAttendance = recordRepository.countByEventAndMember(member, event);
        return ((double) totalAttendance / totalSessions) * 100;
    }
}
