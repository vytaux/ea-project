package com.tg5.repository;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends BaseRepository<Record, Long> {
    @Query("SELECT r FROM Record r " +
            "JOIN FETCH r.member m " +
            "JOIN FETCH r.session s " +
            "JOIN FETCH r.scanner sc " +
            "WHERE sc.scannerCode = :scannerCode")
    List<Record> findAllByScannerCode(@Param("scannerCode") String scannerCode);

    @Query("SELECT COUNT(r) FROM Record r " +
            "WHERE r.session.event = :event " +
            "   AND r.member = :member"
    )
    int getCountByEventAndMember(Event event, Member member);

    @Query("SELECT r FROM Record r WHERE r.id = :recordId AND r.scanner.scannerCode = :scannerCode")
    Optional<Record> findByIdAndScanner_ScannerCode(@Param("recordId") Long recordId, @Param("scannerCode") String scannerCode);


}
