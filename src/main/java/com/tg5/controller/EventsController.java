package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.SessionRepository;
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

//    private final EventRepository eventRepository;
@Autowired
    RecordRepository recordRepository;

@Autowired
    EventService eventService;
@Autowired
    EventRepository eventRepository;

@Autowired
    SessionRepository sessionRepository;

//    @GetMapping("/{eventId}/attendance")
//    public List<Record> findAllRecordsByEventId(Long eventId){
//        return
//    }

//    @GetMapping(path="/{eventId}/attendance")
//       public ResponseEntity<?> getAttendanceByEventId(@PathVariable(value = "eventId") Long eventId){
//        Map<String, Double> members = new HashMap<>();
//        // get event by id
//                Event event = eventRepository.findById(eventId).orElseThrow();
//                     int total = event.getSessions().size();
//                 for(Member mem : event.getMembers()){
//                     int memberSession = recordRepository.countByEventAndMember(mem,event);
//                         Double calculatedPercentage = ((double) memberSession/total)*100;
//                     members.put(mem.getFirstname(), calculatedPercentage);
//                 }
//        return ResponseEntity.ok(members);
//     }
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


    //TODO sessions CRUD /events/{eventId}/sessions
//    @GetMapping("/{eventId}/sessions")
//    public List<Session> getEventSessions(@PathVariable Long eventId) {
//        Event byId = eventRepository.findById(eventId)
//                .orElseThrow();
//
//        return byId.getSessions();
//    }
    // TODO [advanced] calculate attendance GET /events/{eventId}/attendance
}
