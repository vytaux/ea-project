package com.tg5.service;

import com.tg5.service.reports.AttendanceByAccountTypeAndWithinIntervalReport;

import java.time.LocalDate;
import java.util.Map;

public interface AttendanceService {

    Map<String, Double> getAttendanceByEventId(Long eventId);

    Map<String, Double> getAttendancePerMemberForAllAccount(Long userId);

    Map<String, Double> calculateAttendancePerMemberForEvent(Long memberId, Long eventId);

    AttendanceByAccountTypeAndWithinIntervalReport getAttendanceByAccountTypeByDateFromTo(
            String accountType,
            LocalDate fromDate,
            LocalDate toDate
    );
}
