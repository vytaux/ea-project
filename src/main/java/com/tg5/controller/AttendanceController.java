package com.tg5.controller;

import com.tg5.service.AttendanceService;
import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/events/{eventId}/attendance")
    public Map<String, Double> getAttendanceByEventId(@PathVariable Long eventId) {
        return attendanceService.getAttendanceByEventId(eventId);
    }

    @GetMapping("/members/{memberId}/attendance")
    public Map<String, Double> getAttendancePerMemberForAllAccount(@PathVariable Long memberId) {
        return attendanceService.getAttendancePerMemberForAllAccount(memberId);
    }

    @GetMapping("/members/{memberId}/events/{eventId}/attendance")
    public double getMemberOverEventAttendance(@PathVariable Long memberId, @PathVariable Long eventId) {
        return attendanceService.calculateAttendancePerMemberForEvent(memberId, eventId);
    }

    @GetMapping("/accounts/{accountType}/attendance/{fromDate}/{toDate}")
    public AttendanceByAccountTypeByDateFromToReport getMemberEventAttendanceByAccountTypeAndDate(
            @PathVariable String accountType,
            @PathVariable String fromDate,
            @PathVariable String toDate
    ) {
        return attendanceService.getAttendanceByAccountTypeByDateFromTo(
                accountType,
                fromDate,
                toDate
        );
    }
}
