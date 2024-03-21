package com.tg5.controller;

import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;
import com.tg5.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping("/events/{eventId}/attendance")
    public ResponseEntity<?> getEventAttendance(@PathVariable Long eventId) {
        return null;
    }

    @GetMapping("/member/{memberId}/attendance")
    public ResponseEntity<?> getMemberOverDifferentAccountsAttendance(@PathVariable Long userId) {
        return null;
    }

    @GetMapping("/member/{memberId}/events/{eventId}/attendance")
    public ResponseEntity<?> getMemberOverEventAttendance(@PathVariable Long memberId, @PathVariable Long eventId) {
        return null;
    }

    @GetMapping("/accounts/{accountType}/attendance/{fromDate}/{toDate}")
    public ResponseEntity<?> getMemberEventAttendanceByAccountTypeAndDate(
            @PathVariable String accountType,
            @PathVariable String fromDate,
            @PathVariable String toDate
    ) {
        AttendanceByAccountTypeByDateFromToReport response =
                attendanceService.getAttendanceByAccountTypeByDateFromTo(
                        accountType,
                        fromDate,
                        toDate
                );

        return ResponseEntity.ok(response);
    }
}
