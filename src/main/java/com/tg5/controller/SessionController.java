package com.tg5.controller;

import com.tg5.domain.*;
import com.tg5.repository.ScannerRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.SessionService;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{eventId}/allSessions")
public class SessionController extends BaseReadWriteController<SessionPayload, Session, Long> {
}
//    @Autowired
//    SessionRepository sessionRepository;

    //    private final SessionRepository sessionRepository;
//
//    public SessionController(SessionRepository sessionRepository) {
//
//        this.sessionRepository = sessionRepository;
//    }
//
//}
 //   @GetMapping
//   public List<Session> getAllSessions() {
//
//            return sessionRepository.findAll();
//    }
//}
//    public ResponseEntity<List<Session>> getAllSessionsByEventId(@PathVariable Long eventId) {
//        List<Session> sessions = sessionRepository.getAllSessionsByEventId(eventId);
//        return new ResponseEntity<>(sessions, HttpStatus.OK);
//    }
//}
//
//        @GetMapping("/{sessionId}")
//        public ResponseEntity<Session> getSessionById(@PathVariable Long eventId, @PathVariable Long sessionId) {
//            Session session = sessionService.getSessionById(eventId, sessionId);
//            return new ResponseEntity<>(session, HttpStatus.OK);
//        }
//
//        @PostMapping
//        public ResponseEntity<Session> createSession(@PathVariable Long eventId, @RequestBody Session session) {
//            Session createdSession = sessionService.createSession(eventId, session);
//            return new ResponseEntity<>(createdSession, HttpStatus.CREATED);
//        }
//
//        @PutMapping("/{sessionId}")
//        public ResponseEntity<Session> updateSession(@PathVariable Long eventId, @PathVariable Long sessionId, @RequestBody Session session) {
//            Session updatedSession = sessionService.updateSession(eventId, sessionId, session);
//            return new ResponseEntity<>(updatedSession, HttpStatus.OK);
//        }
//
//        @DeleteMapping("/{sessionId}")
//        public ResponseEntity<Void> deleteSession(@PathVariable Long eventId, @PathVariable Long sessionId) {
//            sessionService.deleteSession(eventId, sessionId);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//    }
