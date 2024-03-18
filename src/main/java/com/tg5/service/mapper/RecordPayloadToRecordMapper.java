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

    private final MemberRepository memberRepository;
    private final SessionRepository sessionRepository;
    private final ScannerRepository scannerRepository;

    public RecordPayloadToRecordMapper(MapperFactory mapperFactory, MemberRepository memberRepository, SessionRepository sessionRepository, ScannerRepository scannerRepository) {
        super(mapperFactory, RecordPayload.class, Record.class);
        this.memberRepository = memberRepository;
        this.sessionRepository = sessionRepository;
        this.scannerRepository = scannerRepository;
    }

    @Override
    protected Record customMapping(RecordPayload source, Record target) {
        Member member = memberRepository.findById(source.getMember().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found"));
        target.setMember(member);

        Session session = sessionRepository.findById(source.getSession().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Session not found"));
        target.setSession(session);

        Scanner scanner = scannerRepository.findById(source.getScanner().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Scanner not found"));
        target.setScanner(scanner);

        return target;
    }
}
