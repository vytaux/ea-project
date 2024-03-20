package com.tg5.service.mapper;

import com.tg5.domain.*;
import com.tg5.domain.Record;
import com.tg5.repository.MemberRepository;
import com.tg5.repository.ScannerRepository;
import com.tg5.repository.SessionRepository;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordPayloadToRecordMapper extends BaseMapper<RecordPayload, Record> {

    public RecordPayloadToRecordMapper(MapperFactory mapperFactory) {
        super(mapperFactory, RecordPayload.class, Record.class);
    }
}
