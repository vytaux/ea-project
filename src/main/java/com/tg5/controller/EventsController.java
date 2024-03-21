package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.AttendanceServiceImpl;
import com.tg5.service.EventService;
import com.tg5.service.contract.EventPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.miu.common.controller.BaseReadWriteController;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/events")
public class EventsController extends BaseReadWriteController<EventPayload, Event, Long> {

}

