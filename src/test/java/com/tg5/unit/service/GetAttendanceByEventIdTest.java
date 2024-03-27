package com.tg5.unit.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.repository.EventRepository;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.AttendanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class GetAttendanceByEventIdTest {

    private AttendanceServiceImpl attendanceService;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private RecordRepository recordRepository;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private SessionRepository sessionRepository;

    @BeforeEach
    void setUp() {
        attendanceService = new AttendanceServiceImpl(
                memberRepository,
                eventRepository,
                recordRepository,
                sessionRepository
        );
    }

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
        mockEvent.setSessions(Arrays.asList(new Session(), new Session(), new Session(), new Session()));
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
