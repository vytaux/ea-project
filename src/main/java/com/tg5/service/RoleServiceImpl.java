package com.tg5.service;

import com.tg5.domain.Role;
import com.tg5.repository.RoleRepository;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseReadWriteServiceImpl<RolePayload, Role, Long> implements RoleService {

//    @Autowired
//    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public RolePayload create(RolePayload request) {
//        List<AccountType> types =  accountTypeRepository.findAccountTypesByIdIn(request.getDefaultAccountTypes());
//        Role role = new Role();
//        role.setName(request.getName());
//        role.setDefaultAccountTypes(types);
//        roleRepository.save(role);
//        request.setId(role.getId());
        return request;
    }
}

