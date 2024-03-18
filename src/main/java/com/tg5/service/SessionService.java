package com.tg5.service;

import com.tg5.domain.Session;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface SessionService extends BaseReadWriteService <SessionPayload, Session, Long>{

}
