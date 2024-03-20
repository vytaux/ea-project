package com.tg5.service.mapper;

import com.tg5.domain.AccountType;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeToAccountTypePayload extends BaseMapper<AccountType, AccountTypePayload> {
    protected AccountTypeToAccountTypePayload(MapperFactory mapperFactory) {
        super(mapperFactory, AccountType.class, AccountTypePayload.class);
    }

    @Override
    protected AccountTypePayload customMapping(AccountType accountType, AccountTypePayload accountTypePayload) {
        accountTypePayload.setCurrencyType(accountType.getBalance().getMoneyType().toString());
        accountTypePayload.setBalance(String.valueOf(accountType.getBalance().valueOf()));
       return accountTypePayload;
    }
}
