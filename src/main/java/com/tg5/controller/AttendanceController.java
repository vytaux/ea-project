package com.tg5.controller;


import com.tg5.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("")
public class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/members/{memberId}/attendances")
    public ResponseEntity<?> getAttendances(@PathVariable Long memberId) {
        Map<Long, Double> response = attendanceService.calculateAttendancePerMemberForEachAccount(memberId);
        // compute each member per account
        return ResponseEntity.ok(response);
    }

}
