package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.response.AttendanceByAccountTypeByDateFromToResponse;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final EventRepository eventRepository;
    private final RecordRepository recordRepository;

    @Override
    public AttendanceByAccountTypeByDateFromToResponse getAttendanceByAccountTypeByDateFromTo(
            AccountType accountType,
            String fromDate,
            String toDate
    ) {
        LocalDateTime from = LocalDate.parse(fromDate).atTime(0, 0);
        LocalDateTime to = LocalDate.parse(toDate).atTime(23, 59, 59);

        AttendanceByAccountTypeByDateFromToResponse response =
                new AttendanceByAccountTypeByDateFromToResponse();

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
