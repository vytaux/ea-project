package com.tg5.controller;

import com.tg5.domain.Location;
import com.tg5.domain.Member;
import com.tg5.domain.Role;
import com.tg5.repository.MemberRepository;
import com.tg5.service.contract.LocationPayload;
import com.tg5.service.contract.MemberPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MemberPayload, Member, Long>{

    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance

    // TODO [advanced] calculate attendance single member, single event
    //      GET /members/{memberId}/events/{eventId}/attendance

}
