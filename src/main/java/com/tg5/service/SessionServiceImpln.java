package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpln extends BaseReadWriteServiceImpl<SessionPayload, Session, Long> implements SessionService {
}
//    @Autowired
//    SessionRepository sessionRepository;
//    @Override
//    public List<Session> getAllSessionsByEventId(Long eventId) {
//        return sessionRepository.getAllSessionsByEventId(eventId);
    //}


//public class SessionServiceImpl implements SessionService {
//
//    private final SessionRepository sessionRepository;
//    private final EventRepository eventRepository;
//
//    public SessionServiceImpl(SessionRepository sessionRepository, EventRepository eventRepository) {
//        this.sessionRepository = sessionRepository;
//        this.eventRepository = eventRepository;
//    }

//    @Override
//    public List<Session> getAllSessionsByEventId(Long eventId) {
//        return sessionRepository.findByEventId(eventId);
//    }

//    @Override
//    public Session getSessionById(Long eventId, Long sessionId) {
//        Optional<Session> optionalSession = sessionRepository.findById(sessionId);
//        if (optionalSession.isPresent()) {
//            Session session = optionalSession.get();
//            if (session.getEvent().getId().equals(eventId)) {
//                return session;
//            } else {
//                throw new IllegalArgumentException("Session does not belong to the specified event");
//            }
//        } else {
//            throw new IllegalArgumentException("Session not found");
//        }
//    }

//    @Override
//    public Session createSession(Long eventId, Session session) {
//        Event event = eventRepository.findById(eventId)
//                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
//        session.setEvent(event);
//        return sessionRepository.save(session);
//    }

//    @Override
//    public Session updateSession(Long eventId, Long sessionId, Session updatedSession) {
//        Session existingSession = getSessionById(eventId, sessionId);
//        existingSession.setDayOfWeek(updatedSession.getDayOfWeek());
//        existingSession.setStartTime(updatedSession.getStartTime());
//        existingSession.setEndTime(updatedSession.getEndTime());
//        return sessionRepository.save(existingSession);
////    }
//
//    @Override
//    public void deleteSession(Long eventId, Long sessionId) {
//        Session sessionToDelete = getSessionById(eventId, sessionId);
//        sessionRepository.delete(sessionToDelete);
//    }



