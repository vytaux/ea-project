package com.tg5.service.mapper;

import com.tg5.domain.Role;
import com.tg5.domain.Session;
import com.tg5.service.contract.RolePayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class RoleToRolePayloadMapper extends BaseMapper<Role, RolePayload> {

	public RoleToRolePayloadMapper(MapperFactory mapperFactory) {
		super(mapperFactory, Role.class, RolePayload.class);
	}
}
