package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.service.contract.EventPayload;
import org.springframework.web.bind.annotation.*;

import edu.miu.common.controller.BaseReadWriteController;

@RestController
@RequestMapping("/events")
public class EventsController extends BaseReadWriteController<EventPayload, Event, Long> {

//    private final EventRepository eventRepository;

    // TODO events CRUD
//    @GetMapping
//    public List<Event> getEvents() {
//        return eventRepository.findAll();
//    }
//
//    @PostMapping
//    public Event createEvent(@RequestBody Event event) {
//        return eventRepository.save(event);
//    }

//    @PutMapping("/{eventId}")
//    public Event updateEvent(@PathVariable Long eventId, @RequestBody Event event) {
//        Event byId = eventRepository.findById(eventId)
//                .orElseThrow();
//
//        byId.setName(event.getName());
//        byId.setStartDate(event.getStartDate());
//        byId.setEndDate(event.getEndDate());
//        byId.setSessions(event.getSessions());
//
//        return eventRepository.save(byId);
//    }

//    @DeleteMapping("/{eventId}")
//    public void deleteEvent(@PathVariable Long eventId) {
//        eventRepository.deleteById(eventId);
//    }


    // TODO sessions CRUD /events/{eventId}/sessions
//    @GetMapping("/{eventId}/sessions")
//    public List<Session> getEventSessions(@PathVariable Long eventId) {
//        Event byId = eventRepository.findById(eventId)
//                .orElseThrow();
//
//        return byId.getSessions();
//    }
    // TODO [advanced] calculate attendance GET /events/{eventId}/attendance
}
