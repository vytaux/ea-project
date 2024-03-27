package com.tg5.unit.service;


import com.tg5.domain.AccountType;
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
public class GetAttendancePerMemberForAllAccountTest {

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
    public void getAttendancePerMemberForAllAccountTest() {
        // mock members
        Member mockMember = new Member();
        mockMember.setFirstname("Test");
        mockMember.setLastname("Member");


        // Create mock event
        Event mockEvent1 = new Event();
        mockEvent1.setName("Event test 1");

        Event mockEvent2 = new Event();
        mockEvent2.setName("Event test 2");

        AccountType accountType1 = new AccountType();
        accountType1.setName("GYM");
        mockEvent1.setAccountType(accountType1);

        AccountType accountType2 = new AccountType();
        accountType2.setName("DINING");
        mockEvent2.setAccountType(accountType2);


        // mock sessions
        mockEvent1.setSessions(Arrays.asList(new Session(), new Session()));
        mockEvent2.setSessions(Arrays.asList(new Session(), new Session()));
        mockEvent1.setMembers(List.of(mockMember));
        mockEvent2.setMembers(List.of(mockMember));

        // Set up mock behavior
        when(memberRepository.findById(any()))
                .thenReturn(Optional.of(mockMember));

        when(eventRepository.findAllEventsByMemberId(any()))
                .thenReturn(List.of(mockEvent1, mockEvent2));

        when(recordRepository.countByEventAndMember(any(), any()))
                .thenReturn(1).thenReturn(1);

        Map<String, Double> attendances = attendanceService.getAttendancePerMemberForAllAccount(1L);
        assertNotNull(attendances);
        verify(memberRepository, times(1)).findById(Mockito.any(Long.class));
        verify(eventRepository, times(1)).findAllEventsByMemberId(Mockito.any(Long.class));
        verify(recordRepository, times(2)).countByEventAndMember(any(), any());
        assertThat(attendances, hasEntry("GYM", 50.0));
        assertThat(attendances, hasEntry("DINING", 50.0));
    }
}
