package com.tg5.service.mapper;

import com.tg5.domain.Member;
import com.tg5.service.contract.MemberPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberToMemberPayloadMapper extends BaseMapper<Member, MemberPayload> {
    public MemberToMemberPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Member.class, MemberPayload.class);
    }
}
