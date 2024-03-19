package com.tg5.service;

import com.tg5.domain.Record;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.service.BaseReadWriteService;

import java.util.List;

public interface RecordService extends BaseReadWriteService<RecordPayload, Record, Long> {
    List<Record> findAllByScannerCode(String scannerCode);
}
