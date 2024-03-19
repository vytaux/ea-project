package com.tg5.repository;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepository extends BaseRepository<Record, Long> {

    @Query("SELECT COUNT(r) FROM Record r " +
            "WHERE r.session.event = :event " +
            "   AND r.member = :member"
    )
    int getCountByEventAndMember(Event event, Member member);
}
