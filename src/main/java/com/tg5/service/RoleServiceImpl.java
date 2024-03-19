package com.tg5.service;

import com.tg5.domain.AccountType;
import com.tg5.domain.Role;
import com.tg5.repository.AccountTypeRepository;
import com.tg5.repository.RoleRepository;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseReadWriteServiceImpl<RolePayload, Role, Long> implements RoleService {

    private final AccountTypeRepository accountTypeRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(AccountTypeRepository accountTypeRepository, RoleRepository roleRepository) {
        this.accountTypeRepository = accountTypeRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public RolePayload create(RolePayload request) {
        List<AccountType> types =  accountTypeRepository.findAccountTypesByIdIn(request.getDefaultAccountTypes());
        Role role = new Role();
        role.setName(request.getName());
        role.setDefaultAccountTypes(types);
        roleRepository.save(role);
        request.setId(role.getId());
        return request;
    }
}

