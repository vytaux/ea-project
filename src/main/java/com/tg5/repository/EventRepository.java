package com.tg5.repository;

import com.tg5.domain.Event;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends BaseRepository<Event, Long> {
    Event getEventByAccountType_Id(Long id);
}
