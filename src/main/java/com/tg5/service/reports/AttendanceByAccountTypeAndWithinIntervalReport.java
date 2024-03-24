package com.tg5.service.reports;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
public class AttendanceByAccountTypeAndWithinIntervalReport {

    private String accountType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Map<String, Double> attendancePercentage = new HashMap<>();
}
