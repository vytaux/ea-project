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
@RequestMapping("/events/{eventId}/sessions")
public class SessionsController extends BaseReadWriteController<SessionPayload, Session, Long> {
}
