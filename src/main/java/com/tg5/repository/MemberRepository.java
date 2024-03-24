package com.tg5.repository;

import com.tg5.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MemberRepository extends BaseRepository<Member, Long> {
    @Query("SELECT r.session.event.members FROM Record r " +
            "WHERE r.session.event.accountType.name = :accountType" +
            "   AND :from <= r.scanDateTime AND r.scanDateTime <= :to")
    List<Member> getByEventAccountTypeAndScanDateTimeBetween(String accountType, LocalDateTime from, LocalDateTime to);
}
