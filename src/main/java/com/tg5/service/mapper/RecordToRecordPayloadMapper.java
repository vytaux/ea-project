package com.tg5.service.mapper;

import com.tg5.domain.Record;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RecordToRecordPayloadMapper extends BaseMapper<Record, RecordPayload> {
    public RecordToRecordPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Record.class, RecordPayload.class);
    }
}
