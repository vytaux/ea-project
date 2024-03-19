package com.tg5.service;

import com.tg5.domain.Role;
import com.tg5.domain.Session;
import com.tg5.service.contract.RolePayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseReadWriteServiceImpl<RolePayload, Role, Long> implements RoleService {

}
