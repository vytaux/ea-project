package com.tg5.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberPayload implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String firstname;
    private String lastname;

    private String email;
}
