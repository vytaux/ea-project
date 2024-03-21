package com.tg5.service.reports;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class AttendanceByAccountTypeByDateFromToReport {

    private String accountType;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Map<String, Double> attendancePercent = new HashMap<>();
}
