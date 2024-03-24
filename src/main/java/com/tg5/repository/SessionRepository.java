package com.tg5.repository;

import com.tg5.domain.Member;
import com.tg5.domain.Session;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface SessionRepository extends BaseRepository<Session, Long> {

    @Query("SELECT COUNT(s) FROM Session s" +
            " WHERE s.event.accountType.name = :accountType" +
            "   AND :member MEMBER OF s.event.members" +
            "   AND :from <= s.startDateTime AND s.endDateTime <= :to")
    int countByMemberAndAccountTypeAndStartEndTimeBetween(
            Member member,
            String accountType,
            LocalDateTime from,
            LocalDateTime to
    );
}
