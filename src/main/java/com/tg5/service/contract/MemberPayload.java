package com.tg5.service.contract;

import com.tg5.domain.Role;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String barcode;

    private List<RolePayload> roles = new ArrayList<>();

    public void addRole(RolePayload role){
        roles.add(role);
    }

    public void removeRole(int roleId){
        roles.removeIf(role -> role.getId() == roleId);
    }
}
