package com.tg5.service;

import com.tg5.domain.Member;
import com.tg5.domain.Session;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//

public interface SessionService extends BaseReadWriteService <SessionPayload, Session, Long>{
}


