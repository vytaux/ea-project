package com.tg5.unit.service.mapper;

import com.tg5.domain.Event;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.SessionPayload;
import com.tg5.service.mapper.SessionPayloadToSessionMapper;
import edu.miu.common.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

// TODO redo with @ExtendWith(SpringExtension.class)
@SpringBootTest
class SessionPayloadToSessionMapperTest {

    @MockBean
    private EventRepository eventRepository;

    @Autowired
    private SessionPayloadToSessionMapper mapper;

    @Test
    void testThrowsExceptionWhenEventNotFound() {
        SessionPayload payload = new SessionPayload();
        EventPayload eventPayload = new EventPayload();
        eventPayload.setId(1L);
        payload.setEvent(eventPayload);

        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> mapper.map(payload));
    }

    @Test
    void testSetsTheEventEntityToSession() {
        SessionPayload payload = new SessionPayload();
        EventPayload eventPayload = new EventPayload();
        eventPayload.setId(1L);
        payload.setEvent(eventPayload);

        Event event = new Event();
        when(eventRepository.findById(any(Long.class))).thenReturn(Optional.of(event));

        Session session = mapper.map(payload);

        assertEquals(event, session.getEvent());
    }
}