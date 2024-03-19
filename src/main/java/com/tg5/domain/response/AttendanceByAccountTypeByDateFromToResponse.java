package com.tg5.domain.response;

import com.tg5.domain.AccountType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class AttendanceByAccountTypeByDateFromToResponse {

    private AccountType accountType;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private Map<String, Double> attendancePercent = new HashMap<>();
}
