package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.response.AttendanceByAccountTypeByDateFromToResponse;

public interface AttendanceService {

    AttendanceByAccountTypeByDateFromToResponse getAttendanceByAccountTypeByDateFromTo(
            AccountType accountType,
            String fromDate,
            String toDate
    );
}
