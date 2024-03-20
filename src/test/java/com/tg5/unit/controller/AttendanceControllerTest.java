package com.tg5.unit.controller;

import com.tg5.controller.AttendanceController;
import com.tg5.domain.AccountType;
import com.tg5.domain.response.AttendanceByAccountTypeByDateFromToResponse;
import com.tg5.service.AttendanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// TODO SecurityAutoConfiguration ???
@WebMvcTest(controllers = AttendanceController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class AttendanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttendanceService attendanceService;

    @Test
    public void testGetMemberEventAttendanceByAccountTypeAndDate() throws Exception {
        when(attendanceService.getAttendanceByAccountTypeByDateFromTo(any(AccountType.class), anyString(), anyString()))
                .thenReturn(new AttendanceByAccountTypeByDateFromToResponse());

        mockMvc.perform(get("/accounts/DINING_POINTS/attendance/2022-01-01/2022-12-31")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}