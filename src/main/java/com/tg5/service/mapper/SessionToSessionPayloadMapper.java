package com.tg5.service.mapper;

import com.tg5.domain.Event;
import com.tg5.domain.Session;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionToSessionPayloadMapper extends BaseMapper<Session, SessionPayload> {

	public SessionToSessionPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Session.class, SessionPayload.class);
	}
}
