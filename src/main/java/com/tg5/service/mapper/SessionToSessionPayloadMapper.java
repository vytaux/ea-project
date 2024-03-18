package com.tg5.service.mapper;

import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionToSessionPayloadMapper extends BaseMapper<Session, SessionPayload> {
    public SessionToSessionPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Session.class, SessionPayload.class);
    }
}