package com.tg5.repository;

import com.azure.core.annotation.QueryParam;
import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;



public interface EventRepository extends BaseRepository<Event, Long> {

    @Query("SELECT e FROM Event e " +
            "WHERE e.accountType.name = :accountType " +
            "   AND :from <= e.startDateTime" +
            "   AND e.endDateTime <= :to"
    )
    List<Event> getByAccountTypeAndDateFromTo(
            @QueryParam("accountType") String accountType,
            @QueryParam("from") LocalDateTime from,
            @QueryParam("to") LocalDateTime to
    );

    @Query("SELECT COUNT(r) FROM Record r " +
            "WHERE r.session.event = :event " +
            "   AND r.member = :member"
    )
    int getCountByEventAndMember(Event event, Member member);

    Event findEventByAccountType(AccountType accountType);

    @Query("select e from  Event e inner join e.members s where s.id = :memberId")
    List<Event> findAllEventsByMemberId(Long memberId);
}
