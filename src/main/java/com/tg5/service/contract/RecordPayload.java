package com.tg5.service.contract;

import com.tg5.domain.Member;
import com.tg5.domain.Session;
import lombok.Data;

import java.io.Serializable;

@Data
public class RecordPayload implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Member member;
    private Session session;
}
