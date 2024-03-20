/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
 **/

package com.tg5.controller;

import com.tg5.domain.Account;
import com.tg5.service.AttendanceCalculator;
import com.tg5.service.contract.AccountPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/accounts")
public class  AccountsController extends BaseReadWriteController<AccountPayload, Account, Long> {

    private AttendanceCalculator attendanceCalculator;

    @Autowired
    public void setAttendanceCalculator(AttendanceCalculator attendanceCalculator) {
        this.attendanceCalculator = attendanceCalculator;
    }
    /**
     * TODO accounts CRUD
     * TODO [advanced] calculate attendance GET /members/{memberId}/attendance
     * TODO [advanced] accountance for a particulat account type (over all events) for a date range
     * GET /accounts/{accountId}/attendance/2020-01-01/2020-12-31
     **/
    @GetMapping("/{accountId}/attendance/{startDate}/{endDate}")
    public ResponseEntity<?> calculateAttendanceWithInterval(@PathVariable Long accountId,
                                                             @PathVariable String startDate,  @PathVariable String endDate) {

        return ResponseEntity.ok(attendanceCalculator.calculateAttendanceWithInterval(accountId, startDate, endDate));
    }
}
