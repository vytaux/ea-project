package com.tg5.controller;

import com.tg5.domain.*;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events/{eventId}/sessions")
public class SessionsController extends BaseReadWriteController<SessionPayload, Session, Long> {
}
