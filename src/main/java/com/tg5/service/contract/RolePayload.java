package com.tg5.service.contract;

import com.tg5.domain.AccountType;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RolePayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;
    private long id;
    private String name;
    private List<AccountType> defaultAccountTypes = new ArrayList<>();
}
