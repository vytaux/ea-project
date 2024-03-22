package com.tg5.repository;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import com.tg5.domain.Session;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface RecordRepository extends BaseRepository<Record, Long> {

    @Query("SELECT COUNT(r) FROM Record r " +
            "WHERE r.session.event=:event " +
            "AND r.member=:member")
    int countByEventAndMember(Member member, Event event);

}
