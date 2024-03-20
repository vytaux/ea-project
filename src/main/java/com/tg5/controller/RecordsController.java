package com.tg5.controller;

import com.tg5.domain.Scanner;
import com.tg5.repository.RecordRepository;
import com.tg5.service.RecordServiceImpl;
import com.tg5.service.ScannerServiceImpl;
import com.tg5.service.contract.RecordPayload;
import com.tg5.domain.Record;
import edu.miu.common.controller.BaseReadWriteController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/scanners/{scannerCode}/record")
@RequiredArgsConstructor
public class RecordsController {

    private final RecordServiceImpl recordService;


    @GetMapping
    public List<Record> findAllRecordsByScannerCode(@PathVariable String scannerCode) {
        return recordService.findAllByScannerCode(scannerCode);
    }

    @PostMapping
    public ResponseEntity<?> addRecord(@PathVariable("scannerCode") String scannerCode,
                                       @RequestBody Record record) {
        Record record1 = recordService.addRecord(scannerCode, record);
        return new ResponseEntity<>(record1, HttpStatus.CREATED);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<?> updateRecord(@PathVariable("scannerCode") String scannerCode,
                                          @PathVariable("recordId") Long recordId,
                                          @RequestBody Record record) {
        Record updatedRecord = recordService.updateRecord(scannerCode, recordId, record);
        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<?> deleteRecord(@PathVariable("scannerCode") String scannerCode,
                                          @PathVariable("recordId") Long recordId) {
        recordService.deleteRecord(scannerCode, recordId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}