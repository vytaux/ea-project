package com.tg5.unit.repository;

import com.tg5.domain.*;
import com.tg5.domain.Record;
import com.tg5.repository.RecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecordRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RecordRepository recordRepository;

    @Test
    public void testGetCountByEventAndMember() {

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


        assertEquals(1, count);
    }
    @Test
    public void testFindAllByScannerCode() {
        String scannerCode = "testScannerCode";
        Scanner scanner = new Scanner();
        scanner.setScannerCode(scannerCode);
        entityManager.persist(scanner);

        Record record = new Record();
        record.setScanner(scanner);
        entityManager.persist(record);
        entityManager.flush();

        List<Record> records = recordRepository.findAllByScannerCode(scannerCode);

        assertEquals(1, records.size());
        assertEquals(record.getId(), records.get(0).getId());
    }}
