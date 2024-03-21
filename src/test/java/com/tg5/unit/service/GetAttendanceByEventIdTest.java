package com.tg5.unit.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.service.AttendanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GetAttendanceByEventIdTest {
    @Autowired
    private AttendanceServiceImpl attendanceService;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private RecordRepository recordRepository;

    @Test
    public void getAttendanceByEventIdTest() {
        // mock members
        Member mockMember1 = new Member();
        mockMember1.setFirstname("Test 1");
        mockMember1.setLastname("Member 1");

        Member mockMember2 = new Member();
        mockMember2.setFirstname("Test 2");
        mockMember2.setLastname("Member 2");

        // Create mock event
        Event mockEvent = new Event();
        mockEvent.setName("Event test");


        // mock sessions
        Session mockSession1 = new Session();
        mockSession1.setEvent(mockEvent);
        Session mockSession2 = new Session();
        mockSession2.setEvent(mockEvent);

        Session mockSession3 = new Session();
        mockSession3.setEvent(mockEvent);
        Session mockSession4 = new Session();
        mockSession4.setEvent(mockEvent);

        mockEvent.setSessions(Arrays.asList(mockSession1, mockSession2, mockSession3, mockSession4));
        mockEvent.setMembers(List.of(mockMember1, mockMember2));

        // Set up mock behavior
        when(eventRepository.findById(any()))
                .thenReturn(Optional.of(mockEvent));
        when(recordRepository.countByEventAndMember(any(), any()))
                .thenReturn(2).thenReturn(4);

        Map<String, Double> attendances = attendanceService.getAttendanceByEventId(1L);
        assertNotNull(attendances);
        verify(eventRepository, times(1)).findById(Mockito.any(Long.class));
        verify(recordRepository, times(2)).countByEventAndMember(any(), any());
        assertThat(attendances, hasEntry("Test 1", 50.0));
        assertThat(attendances, hasEntry("Test 2", 100.0));

    }
}
