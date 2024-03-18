package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.SessionPayload;
import com.tg5.service.mapper.EventPayloadToEventMapper;
import com.tg5.service.mapper.EventToEventPayloadMapper;
import edu.miu.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.miu.common.controller.BaseReadWriteController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventsController extends BaseReadWriteController<EventPayload, Event, Long> {

    // TODO [advanced] calculate attendance GET /events/{eventId}/attendance
}
