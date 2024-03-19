package com.tg5.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccountTypePayload implements Serializable {
    private static final long serialVersionUID = 4L;

    private Long id;

    private String name;

    private String description;

    private String balance;

    private String currencyType;
}
