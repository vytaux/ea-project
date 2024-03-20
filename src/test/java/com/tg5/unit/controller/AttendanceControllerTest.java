package com.tg5.unit.controller;

import com.tg5.controller.AttendanceController;
import com.tg5.service.AttendanceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AttendanceController.class)
public class AttendanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AttendanceService attendanceService;

    // WIP
    @Test
    public void testGetEventAttendance() throws Exception {
        mockMvc.perform(get("/v1/badge-system/events/1/attendance"))
                .andExpect(status().isOk());
    }

    // Add more tests for other endpoints
}