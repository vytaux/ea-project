package com.tg5.service.mapper;

import com.tg5.domain.Role;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RolePayloadToRoleMapper extends BaseMapper<RolePayload, Role> {

    public RolePayloadToRoleMapper(MapperFactory mapperFactory) {
        super(mapperFactory, RolePayload.class, Role.class);
    }
}
