package com.tg5.service.contract;

import com.tg5.domain.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class MemberPayload implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String firstname;
    private String lastname;

    private String email;
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role){
        roles.add(role);
    }

    public void removeRole(int roleId){
        roles.removeIf(role -> role.getId() == roleId);
    }
}
