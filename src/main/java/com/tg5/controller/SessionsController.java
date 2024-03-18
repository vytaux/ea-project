package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.SessionService;
import com.tg5.service.contract.SessionPayload;
import com.tg5.service.mapper.SessionPayloadToSessionMapper;
import com.tg5.service.mapper.SessionToSessionPayloadMapper;
import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.common.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serializable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events/{eventId}/sessions")
public class SessionsController extends BaseReadWriteController<SessionPayload, Session, Long> {

    private final EventRepository eventRepository;
    private final SessionRepository sessionRepository;
    private final SessionPayloadToSessionMapper requestMapper;
    private final SessionToSessionPayloadMapper responseMapper;

    // TODO sessions CRUD /events/{eventId}/sessions
    @PostMapping
    public ResponseEntity<?> create(@RequestBody SessionPayload request) {
        Event event = eventRepository.findById(request.getEvent().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        Session session = requestMapper.map(request);
        session.setEvent(event);

        Session saved = sessionRepository.save(session);
        
        SessionPayload response = responseMapper.map(saved);
        return ResponseEntity.ok(response);
    }
}
