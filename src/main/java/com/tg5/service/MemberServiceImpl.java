package com.tg5.service;

import com.tg5.domain.Member;
import com.tg5.service.contract.MemberPayload;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

}
