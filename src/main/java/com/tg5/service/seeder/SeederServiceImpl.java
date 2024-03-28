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
        members = generateMembers(amount*2, randomSeed);

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

    public List<Member> generateMembers(int amount, int randomSeed) {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Member member = new Member();
            member.setFirstname("firstName" + randomSeed + i);
            member.setLastname("lastName" + randomSeed + i);
            member.setEmail("email" + randomSeed + i + "@example.com");
            member.setBarcode("barcode" + randomSeed + i);
            em.persist(member);
            members.add(member);
        }

        return members;
    }

    private List<Member> getRandomUniqueMembers(List<Member> members, int howMany) {
        Set<Member> randomMembers = new HashSet<>();
        for (int i = 0; i < howMany; i++) {
            int randomMemberIndex = getRandomInt(0, members.size());
            Member randomMember = members.get(randomMemberIndex);
            randomMembers.add(randomMember);
        }

        return randomMembers.stream().toList();
    }

    public void generateEvent(int i, AccountType accountType, int randomSeed) {
        List<Member> eventMembers = getRandomUniqueMembers(members, getRandomInt(members.size()/2, members.size()));

        Event event = new Event();
        event.setName("event" + randomSeed + i);
        event.setStartDateTime(LocalDateTime.parse("2024-01-02T00:00:00"));
        event.setEndDateTime(LocalDateTime.parse("2024-06-06T00:00:00"));
        event.setMembers(eventMembers);
        event.setAccountType(accountType);

        em.persist(event);

        int sessionsCount = getRandomInt(10, 30);
        List<Session> sessions = new ArrayList<>();
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
        List<Member> randomMembers = getRandomUniqueMembers(eventMembers, getRandomInt(eventMembers.size()-1, eventMembers.size()));
        for (Member member : randomMembers) {
            Set<Session> randomSessions = getRandomSessions(sessions, getRandomInt(sessions.size()-1, sessions.size()));
            for (Session session : randomSessions) {
                Record record = new Record();
                record.setMember(member);
                record.setSession(session);
                record.setScanDateTime(LocalDateTime.parse("2024-01-12T00:00:00"));

                em.persist(record);
            }
        }
    }

    private Set<Session> getRandomSessions(List<Session> sessions, int randomInt) {
        Set<Session> randomSessions = new HashSet<>();
        for (int i = 0; i < randomInt; i++) {
            randomSessions.add(sessions.get(getRandomInt(0, sessions.size())));
        }

        return randomSessions;
    }
}
