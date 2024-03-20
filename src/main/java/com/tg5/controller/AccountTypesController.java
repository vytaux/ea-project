package com.tg5.controller;

import com.tg5.domain.AccountType;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account-types")
public class AccountTypesController extends BaseReadWriteController<AccountTypePayload, AccountType, Long> {
}
