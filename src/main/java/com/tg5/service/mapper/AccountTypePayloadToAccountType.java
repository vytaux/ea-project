package com.tg5.service.mapper;

import com.tg5.domain.AccountType;
import com.tg5.service.contract.AccountTypePayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountTypePayloadToAccountType extends BaseMapper<AccountTypePayload, AccountType> {
    protected AccountTypePayloadToAccountType(MapperFactory mapperFactory) {
        super(mapperFactory, AccountTypePayload.class, AccountType.class);
    }
}
