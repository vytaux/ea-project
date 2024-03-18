package com.tg5.service.contract;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SessionPayload implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private EventPayload event;

}

