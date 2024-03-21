package com.tg5.service;

import com.tg5.domain.Member;

import com.tg5.service.contract.MemberPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface MemberService extends BaseReadWriteService <MemberPayload, Member, Long>{

}
