package com.tg5.service;

import com.tg5.domain.Record;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends BaseReadWriteServiceImpl<RecordPayload, Record, Long> implements RecordService {
}



