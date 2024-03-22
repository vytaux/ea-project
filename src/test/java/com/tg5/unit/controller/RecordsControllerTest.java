package com.tg5.unit.controller;

import com.tg5.controller.RecordsController;
import com.tg5.domain.Record;
import com.tg5.service.RecordServiceImpl;
import com.tg5.service.contract.RecordPayload;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RecordsController.class)
@AutoConfigureMockMvc(addFilters = false)
class RecordsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecordServiceImpl recordService;

    @Test
    public void testAddRecord() throws Exception {
        Record record = new Record();
        when(recordService.addRecord("testScannerCode", record)).thenReturn(record);
        mockMvc.perform(post("/scanners/testScannerCode/record")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    @Test
    public void testFindAllRecordsByScannerCode() throws Exception {
        List<Record> records = new ArrayList<>();
        records.add(mock(Record.class));
        records.add(mock(Record.class));
        when(recordService.findAllByScannerCode(anyString())).thenReturn(records);
        mockMvc.perform(get("/scanners/testScannerCode/record")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }
    @Test
    public void testUpdateRecord() throws Exception {
        Record updatedRecord = new Record();
        when(recordService.updateRecord("testScannerCode", 1L, updatedRecord)).thenReturn(updatedRecord);
        mockMvc.perform(put("/scanners/testScannerCode/record/1")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteRecord() throws Exception {
        doNothing().when(recordService).deleteRecord("testScannerCode", 1L);
        mockMvc.perform(delete("/scanners/testScannerCode/record/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
