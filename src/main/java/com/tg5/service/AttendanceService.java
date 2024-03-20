package com.tg5.service;

import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;

public interface AttendanceService {

    AttendanceByAccountTypeByDateFromToReport getAttendanceByAccountTypeByDateFromTo(
            String accountType,
            String fromDate,
            String toDate
    );
}
