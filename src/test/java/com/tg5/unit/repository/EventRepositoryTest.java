package com.tg5.unit.repository;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@DataJpaTest
public class EventRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void testReturnsEventsByAccountTypeAndDateFromTo() {
        LocalDateTime startDateTime = LocalDate.parse("2022-01-01").atTime(0, 0);
        LocalDateTime endDateTime = LocalDate.parse("2022-12-31").atTime(23, 59, 59);

        Event event = new Event();
        event.setName("test-event");
        event.setAccountType(AccountType.DINING_POINTS);
        event.setStartDateTime(startDateTime);
        event.setEndDateTime(endDateTime);

        entityManager.persist(event);
        entityManager.flush();

        List<Event> found = eventRepository.getByAccountTypeAndDateFromTo(
                AccountType.DINING_POINTS,
                startDateTime,
                endDateTime
        );

        assertThat(found, hasSize(1));
        assertThat(found.getFirst().getName())
                .isEqualTo(event.getName());
    }
}
