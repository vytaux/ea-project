package com.tg5.service.mapper;

import com.tg5.domain.Account;
import com.tg5.service.contract.AccountPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountPayloadToAccountMapper extends BaseMapper<AccountPayload, Account>{

	public AccountPayloadToAccountMapper(MapperFactory mapperFactory) {
		super(mapperFactory, AccountPayload.class, Account.class);
	}
}
