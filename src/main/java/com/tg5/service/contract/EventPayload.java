package com.tg5.service.contract;

import com.tg5.domain.AccountType;
import com.tg5.domain.Location;
import com.tg5.domain.Member;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EventPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private AccountType accountType;

    private Location location;

    private List<Member> members;
}