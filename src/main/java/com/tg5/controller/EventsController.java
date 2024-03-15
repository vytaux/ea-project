package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    private final EventRepository eventRepository;

    public EventsController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // TODO events CRUD
    @GetMapping
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    // TODO sessions CRUD /events/{eventId}/sessions
    @GetMapping("/{eventId}/sessions")
    public List<Session> getEventSessions(@PathVariable Long eventId) {
        Event byId = eventRepository.findById(eventId)
                .orElseThrow();

        return byId.getSessions();
    }
    // TODO [advanced] calculate attendance GET /events/{eventId}/attendance
}
