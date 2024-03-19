package com.tg5.service;

import com.tg5.domain.Role;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.service.BaseReadWriteService;

public interface RoleService extends BaseReadWriteService<RolePayload, Role, Long> {
}
