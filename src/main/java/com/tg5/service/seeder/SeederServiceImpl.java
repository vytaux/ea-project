package com.tg5.service.seeder;

import com.tg5.domain.AccountType;
import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Record;
import com.tg5.domain.Session;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeederServiceImpl implements SeederService {

    private EntityManagerFactory emf;
    private EntityManager em;

    private List<Member> members = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getRandomIntSeed() {
        return getRandomInt(1000, 9999);
    }

    @Override
    public void seed(int amount) {
        em = this.emf.createEntityManager();
        em.getTransaction().begin();

        int randomSeed = getRandomIntSeed();
        AccountType accountType = createAccountType();
        generateMembers(amount*2, randomSeed);
        for (int i = 0; i < amount; i++) {
            generateEvent(i, accountType, randomSeed);
        }

        em.getTransaction().commit();
        em.close();
    }


    private AccountType createAccountType() {
        AccountType accountType = new AccountType();
        accountType.setName("accountType");
        em.persist(accountType);
        return accountType;
    }

    public void generateMembers(int amount, int randomSeed) {
        members = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Member member = new Member();
            member.setFirstname("firstName" + randomSeed + i);
            member.setLastname("lastName" + randomSeed + i);
            member.setEmail("email" + randomSeed + i + "@example.com");
            member.setBarcode("barcode" + randomSeed + i);
            em.persist(member);
            members.add(member);
        }
    }

    private Set<Member> getRandomUniqueMembers(int randomInt) {
        Set<Member> randomMembers = new HashSet<>();
        for (int i = 0; i < randomInt; i++) {
            randomMembers.add(members.get(getRandomInt(0, members.size())));
        }

        return randomMembers;
    }

    private Set<Session> getRandomUniqueSessions(int randomInt) {
        Set<Session> randomSessions = new HashSet<>();
        for (int i = 0; i < randomInt; i++) {
            randomSessions.add(sessions.get(getRandomInt(0, sessions.size())));
        }

        return randomSessions;
    }

    public void generateEvent(int i, AccountType accountType, int randomSeed) {
        List<Member> eventMembers = getRandomUniqueMembers(getRandomInt(10, 30)).stream().toList();

        Event event = new Event();
        event.setName("event" + randomSeed + i);
        event.setStartDateTime(LocalDateTime.parse("2024-01-02T00:00:00"));
        event.setEndDateTime(LocalDateTime.parse("2024-06-06T00:00:00"));
        event.setMembers(eventMembers);
        event.setAccountType(accountType);
        em.persist(event);

        int sessionsCount = getRandomInt(10, 30);
        for (int j = 0; j < sessionsCount; j++) {
            Session session = new Session();
            session.setName("session" + randomSeed + i + j);
            session.setEvent(event);
            session.setStartDateTime(LocalDateTime.parse("2024-01-02T00:00:00"));
            session.setEndDateTime(LocalDateTime.parse("2024-06-06T00:00:00"));
            em.persist(session);
            sessions.add(session);
        }

        // records
        Set<Member> randomUniqueMembers = getRandomUniqueMembers(getRandomInt(10, 30));
        for (Member member : randomUniqueMembers) {
            Set<Session> randomUniqueSessions = getRandomUniqueSessions(getRandomInt(10, 30));
            for (Session session : randomUniqueSessions) {
                Record record = new Record();
                record.setMember(member);
                record.setSession(session);
                em.persist(record);
            }
        }
    }
}
