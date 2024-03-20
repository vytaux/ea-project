package com.tg5.repository;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {
    Event findEventByAccountType(AccountType accountType);
}
