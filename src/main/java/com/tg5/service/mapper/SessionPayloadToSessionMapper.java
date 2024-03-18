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

	private final EventRepository eventRepository;

	public SessionPayloadToSessionMapper(EventRepository eventRepository, MapperFactory mapperFactory) {
		super(mapperFactory, SessionPayload.class, Session.class);
        this.eventRepository = eventRepository;
    }

	@Override
	protected Session customMapping(SessionPayload source, Session target) {
		Event event = eventRepository.findById(source.getEvent().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Event not found"));

		target.setEvent(event);

		return target;
	}
}
