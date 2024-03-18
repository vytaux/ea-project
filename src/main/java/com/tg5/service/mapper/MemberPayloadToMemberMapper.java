package com.tg5.service.mapper;

import com.tg5.domain.Account;
import com.tg5.domain.Member;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.MemberPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberPayloadToMemberMapper extends BaseMapper<MemberPayload, Member>{

	public MemberPayloadToMemberMapper(MapperFactory mapperFactory) {
		super(mapperFactory, MemberPayload.class, Member.class);
	}
}
