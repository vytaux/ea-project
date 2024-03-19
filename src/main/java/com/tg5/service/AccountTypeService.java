package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.service.BaseReadWriteService;

public interface AccountTypeService extends BaseReadWriteService<AccountTypePayload, AccountType, Long> {
}
