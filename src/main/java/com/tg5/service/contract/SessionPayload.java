package com.tg5.service.contract;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Data
public class SessionPayload implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private LocalDate dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Member> attendees;
    private Event event;
}
