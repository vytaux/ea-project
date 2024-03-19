package com.tg5.repository;

import com.azure.core.annotation.QueryParam;
import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Record;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {
    @Query("SELECT e FROM Event e " +
            "WHERE e.accountType = :accountType " +
            "   AND :from <= e.startDateTime" +
            "   AND e.endDateTime <= :to"
    )
    List<Event> getByAccountTypeAndDateFromTo(
            @QueryParam("accountType") AccountType accountType,
            @QueryParam("from") LocalDateTime from,
            @QueryParam("to") LocalDateTime to
    );
}
