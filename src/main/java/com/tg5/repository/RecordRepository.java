package com.tg5.repository;

import com.tg5.domain.Record;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends BaseRepository<Record, Long> {
    @Query("SELECT r FROM Record r " +
            "JOIN FETCH r.member m " +
            "JOIN FETCH r.session s " +
            "JOIN FETCH r.scanner sc " +
            "WHERE sc.scannerCode = :scannerCode")
    List<Record> findAllByScannerCode(@Param("scannerCode") String scannerCode);
}
