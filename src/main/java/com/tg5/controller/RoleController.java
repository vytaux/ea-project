package com.tg5.controller;

import com.tg5.domain.Role;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends BaseReadWriteController<RolePayload, Role, Long> {
}
