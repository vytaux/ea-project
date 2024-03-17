package com.tg5.service.mapper;

import com.tg5.domain.Event;
import com.tg5.service.contract.EventPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class EventToEventPayloadMapper extends BaseMapper<Event, EventPayload> {

	public EventToEventPayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Event.class, EventPayload.class);
	}
}
