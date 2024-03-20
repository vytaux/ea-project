package com.tg5.service;

import com.tg5.domain.Record;
import com.tg5.domain.Scanner;
import com.tg5.domain.Session;
import com.tg5.repository.RecordRepository;
import com.tg5.repository.ScannerRepository;
import com.tg5.service.contract.RecordPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl extends BaseReadWriteServiceImpl<RecordPayload, Record, Long> implements RecordService {
    private final RecordRepository recordRepository;
    private final ScannerRepository scannerRepository;


    @Override
    public List<Record> findAllByScannerCode(String scannerCode) {
        return recordRepository.findAllByScannerCode(scannerCode);
    }

    @Override
    public Record addRecord(String scannerCode, Record record) {
        Scanner scanner = scannerRepository.getScannerByScannerCode(scannerCode)
                .orElseThrow(() -> new ResourceNotFoundException("Scanner not found with ID: " + scannerCode));
        record.setScanner(scanner);
        return recordRepository.save(record);
    }

    @Override
    public Record updateRecord(String scannerCode, Long recordId, Record record) {
        Record existingRecord = recordRepository.findByIdAndScanner_ScannerCode(recordId, scannerCode)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with ID: " + recordId));
        record.setId(existingRecord.getId());
        record.setScanner(existingRecord.getScanner());
        return recordRepository.save(record);
    }

    @Override
    public void deleteRecord(String scannerCode, Long recordId) {
        Record record = recordRepository.findByIdAndScanner_ScannerCode(recordId, scannerCode)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found with ID: " + recordId));
        recordRepository.delete(record);
    }
}
