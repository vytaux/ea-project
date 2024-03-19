package com.tg5.controller;

import com.tg5.repository.RecordRepository;
import com.tg5.service.contract.RecordPayload;
import com.tg5.domain.Record;
import edu.miu.common.controller.BaseReadWriteController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scanners/{scannerCode}/records")
@RequiredArgsConstructor
public class RecordsController extends BaseReadWriteController<RecordPayload, Record, Long> {

    private final RecordRepository recordRepository;


    @GetMapping("/all")
    public List<Record> findAllByScannerCode(@PathVariable String scannerCode) {
        return recordRepository.findAllByScannerCode(scannerCode);
    }
}