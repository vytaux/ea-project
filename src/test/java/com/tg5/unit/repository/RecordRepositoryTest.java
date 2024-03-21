package com.tg5.unit.repository;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import com.tg5.domain.Session;
import com.tg5.repository.RecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecordRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void testCountByEventAndMember() {
        // Create and persist a Record with a specific Event and Member
        Member member = new Member();
        Event event = new Event();

        Session session = new Session();
        session.setEvent(event);

        Record record = new Record();
        record.setMember(member);
        record.setSession(session);

        entityManager.persist(member);
        entityManager.persist(event);
        entityManager.persist(session);
        entityManager.persist(record);
        entityManager.flush();

        // Call the countByEventAndMember method with the same Event and Member
        int count = recordRepository.countByEventAndMember(member, event);

        // Assert that the returned count is 1
        assertEquals(1, count);
    }
}
