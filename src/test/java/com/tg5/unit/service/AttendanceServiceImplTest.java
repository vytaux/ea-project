package com.tg5.unit.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.service.AttendanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AttendanceServiceImplTest {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private RecordRepository recordRepository;

    @Test
    public void testGetAttendanceByAccountTypeByDateFromTo() {
        // Create mock data
        Event mockEvent = new Event();
        mockEvent.setSessions(Arrays.asList(new Session(), new Session()));
        Member mockMember = new Member();
        mockMember.setFirstname("Test");
        mockMember.setLastname("Member");
        mockEvent.setMembers(Collections.singletonList(mockMember));

        // Set up mock behavior
        when(eventRepository.getByAccountTypeAndDateFromTo(any(String.class), any(LocalDateTime.class), any(LocalDateTime.class)))
                .thenReturn(Collections.singletonList(mockEvent));
        when(recordRepository.getCountByEventAndMember(any(), any()))
                .thenReturn(1);

        // Call the method
        AttendanceByAccountTypeByDateFromToReport response =
                attendanceService.getAttendanceByAccountTypeByDateFromTo(
                        "student",
                        "2022-01-01",
                        "2022-12-31"
                );

        // Assert the returned data
        assertNotNull(response);
        assertEquals("student", response.getAccountType());
        assertEquals(1, response.getAttendancePercent().size());
        assertTrue(response.getAttendancePercent().containsKey("Test Member"));
        assertEquals(50.0, response.getAttendancePercent().get("Test Member"));
    }
}
