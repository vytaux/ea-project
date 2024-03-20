package com.tg5.repository;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {
    Event findEventByAccountType(AccountType accountType);

    @Query("select e from  Event e inner join e.members s where s.id = :memberId")
    List<Event> findAllEventsByMemberId(Long memberId);
}
