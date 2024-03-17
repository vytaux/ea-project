package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.service.contract.EventPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements EventService {
	
}
