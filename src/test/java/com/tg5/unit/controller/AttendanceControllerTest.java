package com.tg5.unit.controller;

import com.tg5.controller.AttendanceController;
import com.tg5.service.AttendanceService;
import com.tg5.service.reports.AttendanceByAccountTypeByDateFromToReport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AttendanceController.class)
// Skips security somehow
@AutoConfigureMockMvc(addFilters = false)
public class AttendanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttendanceService attendanceService;

    @Test
    public void testGetMemberEventAttendanceByAccountTypeAndDate() throws Exception {
        when(attendanceService.getAttendanceByAccountTypeByDateFromTo(any(String.class), anyString(), anyString()))
                .thenReturn(new AttendanceByAccountTypeByDateFromToReport());

        mockMvc.perform(get("/accounts/student/attendance/2022-01-01/2022-12-31")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}