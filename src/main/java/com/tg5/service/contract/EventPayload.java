package com.tg5.service.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tg5.domain.AccountType;
import com.tg5.domain.Location;
import com.tg5.domain.Member;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private AccountTypePayload accountType;

    private Location location;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startDateTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endDateTime;

    private List<MemberPayload> members = new ArrayList<>();
}