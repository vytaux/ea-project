package com.tg5.service;

import com.tg5.domain.Record;
import com.tg5.domain.Session;
import com.tg5.repository.RecordRepository;
import com.tg5.service.contract.RecordPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl extends BaseReadWriteServiceImpl<RecordPayload, Record, Long> implements RecordService {
    private final RecordRepository recordRepository;

    @Override
    public List<Record> findAllByScannerCode(String scannerCode) {
        return recordRepository.findAllByScannerCode(scannerCode);
    }
}
