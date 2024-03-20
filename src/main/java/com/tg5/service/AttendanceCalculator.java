package com.tg5.service;

public interface AttendanceCalculator {
    double calculateAttendancePerMemberForEvent(Long memberId, Long eventId);
}
