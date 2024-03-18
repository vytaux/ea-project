package com.tg5.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private EventPayload event;

    private String name;
}