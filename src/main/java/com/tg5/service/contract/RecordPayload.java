package com.tg5.service.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RecordPayload implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private MemberPayload member;
    private SessionPayload session;
    private ScannerPayload scanner;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime scanDateTime;
}
