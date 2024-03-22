package com.tg5.unit.controller;

import com.tg5.controller.MembersController;
import com.tg5.service.MemberService;
import com.tg5.service.contract.MemberPayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MembersController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void testGetMemberRoles() throws Exception {
        when(memberService.findById(any()))
                .thenReturn(new MemberPayload());

        mockMvc.perform(get("/members/1/roles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteRole() throws Exception {
        when(memberService.findById(any()))
                .thenReturn(new MemberPayload());

        when(memberService.update(any(), any()))
                .thenReturn(new MemberPayload());

        mockMvc.perform(delete("/members/1/roles/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddRole() throws Exception {
        when(memberService.findById(any()))
                .thenReturn(new MemberPayload());

        when(memberService.update(any(), any()))
                .thenReturn(new MemberPayload());

        mockMvc.perform(post("/members/1/roles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isOk());
    }
}
