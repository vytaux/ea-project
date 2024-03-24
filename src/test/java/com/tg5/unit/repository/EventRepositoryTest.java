package com.tg5.unit.repository;

import com.tg5.domain.Account;
import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
     public void findAllEventsByMemberIdTest() {

        Member member = new Member();
        member.setFirstname("Joe");
        member.setLastname("Doe");
        member.setEmail("joe@miu.ed");
        entityManager.persist(member);

        AccountType accountType = new AccountType();
        accountType.setName("student");
        entityManager.persist(accountType);

        Account account = new Account();
        account.setMember(member);
        account.setAccountType(accountType);
        entityManager.persist(account);

        LocalDateTime startDateTime = LocalDate.parse("2022-01-01").atTime(0, 0);
        LocalDateTime endDateTime = LocalDate.parse("2022-12-31").atTime(23, 59, 59);

        Event event = new Event();
        event.setName("event 1");
        event.setAccountType(accountType);
        event.setStartDateTime(startDateTime);
        event.setEndDateTime(endDateTime);
        event.setMembers(List.of(member));
        entityManager.persist(event);

        List<Event> events = eventRepository.findAllEventsByMemberId(member.getId());
        assertThat(events, hasSize(1));
        assertThat(events, hasItem(hasProperty("name", is("event 1"))));
    }

}
