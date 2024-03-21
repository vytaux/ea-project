package com.tg5.unit.service;

import com.tg5.domain.Record;
import com.tg5.domain.Scanner;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.ScannerRepository;
import com.tg5.service.RecordServiceImpl;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class RecordServiceImplTest {

    @Mock
    private RecordRepository recordRepository;

    @Mock
    private ScannerRepository scannerRepository;

    @InjectMocks
    private RecordServiceImpl recordService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllByScannerCode() {
        String scannerCode = "testScannerCode";
        Record record = new Record();
        when(recordRepository.findAllByScannerCode(anyString())).thenReturn(Collections.singletonList(record));

        List<Record> result = recordService.findAllByScannerCode(scannerCode);

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testAddRecord() {
        String scannerCode = "testScannerCode";
        Record record = new Record();
        Scanner scanner = new Scanner();
        when(scannerRepository.getScannerByScannerCode(anyString())).thenReturn(Optional.of(scanner));
        when(recordRepository.save(any(Record.class))).thenReturn(record);

        Record result = recordService.addRecord(scannerCode, record);

        assertNotNull(result);
        assertEquals(record, result);
    }

    @Test
    public void testUpdateRecord() {
        String scannerCode = "testScannerCode";
        Long recordId = 1L;
        Record record = new Record();
        Record existingRecord = new Record();
        when(recordRepository.findByIdAndScanner_ScannerCode(anyLong(), anyString())).thenReturn(Optional.of(existingRecord));
        when(recordRepository.save(any(Record.class))).thenReturn(record);

        Record result = recordService.updateRecord(scannerCode, recordId, record);

        assertNotNull(result);
        assertEquals(record, result);
    }

    @Test
    public void testDeleteRecord() {
        // Mock data
        String scannerCode = "testScannerCode";
        Long recordId = 1L;
        Record record = new Record();
        when(recordRepository.findByIdAndScanner_ScannerCode(anyLong(), anyString())).thenReturn(Optional.of(record));

        // Call service method
        assertDoesNotThrow(() -> recordService.deleteRecord(scannerCode, recordId));
    }

    @Test
    public void testDeleteRecord_NotFound() {
        // Mock data
        String scannerCode = "testScannerCode";
        Long recordId = 1L;
        when(recordRepository.findByIdAndScanner_ScannerCode(anyLong(), anyString())).thenReturn(Optional.empty());

        // Call service method and verify exception
        assertThrows(ResourceNotFoundException.class, () -> recordService.deleteRecord(scannerCode, recordId));
    }
}
