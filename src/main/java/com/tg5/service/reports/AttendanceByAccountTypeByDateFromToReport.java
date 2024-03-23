package com.tg5.service.reports;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class AttendanceByAccountTypeByDateFromToReport {

    private String accountType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Map<String, Double> attendancePercent = new HashMap<>();
}
