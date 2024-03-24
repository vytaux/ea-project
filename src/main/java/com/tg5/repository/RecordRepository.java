package com.tg5.repository;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


public interface RecordRepository extends BaseRepository<Record, Long> {

    @Query("SELECT COUNT(r) FROM Record r " +
            "WHERE r.session.event = :event " +
            "AND r.member = :member")
    int countByEventAndMember(Member member, Event event);

    @Query("SELECT COUNT(r) FROM Record r " +
            " WHERE r.member = :member " +
            "   AND r.session.event.accountType.name = :accountType" +
            "   AND :from <= r.scanDateTime AND r.scanDateTime <= :to")
    int countByMemberAndAccountTypeAndScanDateTimeBetween(
            Member member,
            String accountType,
            LocalDateTime from,
            LocalDateTime to
    );
}
