package com.tg5.unit.service;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.reports.AttendanceByAccountTypeAndWithinIntervalReport;
import com.tg5.repository.EventRepository;
import com.tg5.repository.RecordRepository;
import com.tg5.service.AttendanceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AttendanceServiceImplTest {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private SessionRepository sessionRepository;

    @MockBean
    private RecordRepository recordRepository;

    @Test
    public void testGetAttendanceByAccountTypeByDateFromTo() {
        // Create mock data
        Member mockMember = new Member();
        mockMember.setFirstname("Test");
        mockMember.setLastname("Member");

        // Set up mock behavior
        when(memberRepository.getByEventAccountTypeAndScanDateTimeBetween(
                any(String.class),
                any(LocalDateTime.class),
                any(LocalDateTime.class))
            ).thenReturn(List.of(mockMember));
        when(sessionRepository.countByMemberAndAccountTypeAndStartEndTimeBetween(
                any(Member.class),
                any(String.class),
                any(LocalDateTime.class),
                any(LocalDateTime.class))
        ).thenReturn(2);
        when(recordRepository.countByMemberAndAccountTypeAndScanDateTimeBetween(
                any(Member.class),
                any(String.class),
                any(LocalDateTime.class),
                any(LocalDateTime.class))
        ).thenReturn(1);

        // Call the method
        AttendanceByAccountTypeAndWithinIntervalReport response =
                attendanceService.getAttendanceByAccountTypeByDateFromTo(
                        "student",
                        LocalDate.parse("2022-01-01"),
                        LocalDate.parse("2022-12-31")
                );

        // Assert the returned data
        assertNotNull(response);
        assertEquals("student", response.getAccountType());
        assertEquals(1, response.getAttendancePercentage().size());
        assertTrue(response.getAttendancePercentage().containsKey("Test Member"));
        assertEquals(50.0, response.getAttendancePercentage().get("Test Member"));
    }
}
