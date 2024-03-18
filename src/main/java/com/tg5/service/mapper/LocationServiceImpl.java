package com.tg5.service.mapper;

import com.tg5.domain.Event;
import com.tg5.service.EventService;
import com.tg5.service.contract.EventPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;

public class LocationServiceImpl extends BaseReadWriteServiceImpl<EventPayload, Event, Long> implements LocationService {
}
