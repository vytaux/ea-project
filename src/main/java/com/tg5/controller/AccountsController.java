package com.tg5.controller;

import com.tg5.domain.Account;
import com.tg5.domain.Event;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.EventPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController extends BaseReadWriteController<AccountPayload, Account, Long> {
    // TODO accounts CRUD


    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance
    // TODO [advanced] accountance for a particulat account type (over all events) for a date range
    //    GET /accounts/{accountId}/attendance/2020-01-01/2020-12-31
}
