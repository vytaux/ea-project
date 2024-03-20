package com.tg5.service;

import java.util.Map;

public interface AttendanceCalculator {
    double calculateAttendancePerMemberForEvent(Long memberId, Long eventId);

    Map<Long, Double> calculateAttendancePerMemberForAllAccount(Long memberId);
}
