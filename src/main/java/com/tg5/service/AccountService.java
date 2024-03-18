package com.tg5.service;

import com.tg5.domain.Account;
import com.tg5.domain.Session;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface AccountService extends BaseReadWriteService <AccountPayload, Account, Long>{

}
