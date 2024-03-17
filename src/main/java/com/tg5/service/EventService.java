package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.service.contract.EventPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface EventService extends BaseReadWriteService <EventPayload, Event, Long>{

}
