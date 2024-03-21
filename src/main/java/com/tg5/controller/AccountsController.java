/**
 * Author: Dip Ranjon Das
 * Date: 03/18/2023
 * Feature: Account
 **/

package com.tg5.controller;

import com.tg5.domain.Account;
import com.tg5.service.contract.AccountPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class  AccountsController extends BaseReadWriteController<AccountPayload, Account, Long> {
}
