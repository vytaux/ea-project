package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface EventService extends BaseReadWriteService <EventPayload, Event, Long>{
   // List<SessionPayload> getAttendanceForEvent(Long eventId);
}
