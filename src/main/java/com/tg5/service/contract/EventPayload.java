package com.tg5.service.contract;

import com.tg5.domain.AccountType;
import com.tg5.domain.Location;
import lombok.Data;

import java.io.Serializable;

@Data
public class EventPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private AccountType accountType;

    private Location location;
}