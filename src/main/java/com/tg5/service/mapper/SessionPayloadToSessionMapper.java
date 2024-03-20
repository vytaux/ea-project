package com.tg5.service.mapper;

import com.tg5.domain.Event;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class SessionPayloadToSessionMapper extends BaseMapper<SessionPayload, Session>{

	public SessionPayloadToSessionMapper(MapperFactory mapperFactory) {
		super(mapperFactory, SessionPayload.class, Session.class);
    }
}
