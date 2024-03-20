package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.domain.Record;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.contract.RecordPayload;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tg5.domain.Record;

import java.util.List;

@Service
public class RecordServiceImpl extends BaseReadWriteServiceImpl<RecordPayload, Record, Long> implements RecordService{




//
//        @Autowired
//        private EventRepository eventRepository;
//
//        @Autowired
//        private SessionRepository sessionRepository;
//
//        @Autowired
//        private RecordRepository recordRepository;
//
//        public int getTotalAttendanceByEventId(Long eventId) {
//            Event event = eventRepository.findById(eventId).orElse(null);
//            if (event == null) {
//                throw new RuntimeException("Event not found with ID: " + eventId);
//            }
//
//            List<Session> sessions = sessionRepository.findByEvent(event);
//            int totalAttendance = 0;
//            for (Session session : sessions) {
//                totalAttendance += recordRepository.countBySession(session);
//            }
//            return totalAttendance;
//        }
    }



