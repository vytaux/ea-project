package com.tg5.repository;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Session;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionRepository extends BaseRepository<Session,Long> {
    List<Session> findByEvent(Event event);


    // List<Session> getAllSessionsByEventId;


}
