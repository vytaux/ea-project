package com.tg5.unit.repository;


import com.tg5.domain.AccountType;
import com.tg5.repository.AccountTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@DataJpaTest
public class AccountTypeTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Test
    public void findAccountTypesByIdIn() {
        AccountType accountType1 = new AccountType();
        accountType1.setName("student");
        AccountType accountType2 = new AccountType();
        accountType1.setName("faculty");
        AccountType accountType3 = new AccountType();
        accountType1.setName("staff");
        entityManager.persist(accountType1);
        entityManager.persist(accountType2);
        entityManager.persist(accountType3);
        entityManager.flush();

        List<AccountType> found = accountTypeRepository.findAccountTypesByIdIn(List.of(
                accountType1.getId(),
                accountType2.getId(), 23465L));
        assertThat(found, hasSize(2));
        assertThat(found, hasItem(hasProperty("id", is(accountType1.getId()))));
        assertThat(found, hasItem(hasProperty("id", is(accountType2.getId()))));
    }
}
