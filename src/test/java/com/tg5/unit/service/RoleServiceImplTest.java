package com.tg5.unit.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Role;
import com.tg5.repository.AccountTypeRepository;
import com.tg5.repository.RoleRepository;
import com.tg5.service.RoleService;
import com.tg5.service.RoleServiceImpl;
import com.tg5.service.contract.RolePayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class RoleServiceImplTest {

    private RoleService roleService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private AccountTypeRepository accountTypeRepository;

    @BeforeEach
    void setUp() {
        roleService = new RoleServiceImpl(accountTypeRepository, roleRepository);
    }

    @Test
    public void testCreate() {
        AccountType accountType = new AccountType();
        accountType.setName("Dining");
        accountType.setId(1L);

        Role mockedRole = new Role();
        mockedRole.setDefaultAccountTypes(List.of(accountType));


        when(accountTypeRepository.findAccountTypesByIdIn(any()))
                .thenReturn(List.of());
        when(roleRepository.save(any(Role.class)))
                .thenReturn(mockedRole);
        mockedRole.setId(1L);


        RolePayload rolePayload = new RolePayload();
        rolePayload.setName("student");
        rolePayload.setDefaultAccountTypes(List.of(accountType));
        RolePayload response = roleService.create(rolePayload);

        assertNotNull(response);
        assertEquals(1, response.getDefaultAccountTypes().size());
        verify(roleRepository, times(1)).save(Mockito.any(Role.class));
        verify(accountTypeRepository, times(1)).findAccountTypesByIdIn(Mockito.any(List.class));

    }
}
