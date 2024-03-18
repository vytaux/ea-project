package com.tg5.service.mapper;

import com.tg5.domain.Account;
import com.tg5.domain.Session;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountPayloadMapper extends BaseMapper<Account, AccountPayload> {

	public AccountToAccountPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Account.class, AccountPayload.class);
	}
}
