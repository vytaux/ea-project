package com.tg5.service;

import java.time.LocalDate;
import java.util.Map;

public interface AttendanceCalculator {
    double calculateAttendancePerMemberForEvent(Long memberId, Long eventId);

    Map<String, Double> calculateAttendancePerMemberForAllAccount(Long memberId);

    Map<Long, Double> calculateAttendanceWithInterval(Long accountId, String startDate, String endDate);
}
