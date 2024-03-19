package com.tg5.service.contract;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RolePayload implements Serializable {

    private static final long serialVersionUID = 3L;
    private long id;
    private String name;
    private List<Long> defaultAccountTypes;
}
