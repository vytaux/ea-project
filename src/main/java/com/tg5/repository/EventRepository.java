package com.tg5.repository;

import com.azure.core.annotation.QueryParam;
import com.tg5.domain.Event;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {

    @Query("SELECT e FROM Event e WHERE e.accountType.name = :accountType" +
            " AND :from <= e.startDateTime AND e.endDateTime <= :to")
    List<Event> getByAccountTypeAndDateFromTo(
            @QueryParam("accountType") String accountType,
            @QueryParam("from") LocalDate from,
            @QueryParam("to") LocalDate to
    );

    @Query("select e from  Event e inner join e.members s where s.id = :memberId")
    List<Event> findAllEventsByMemberId(Long memberId);
}
