package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Member;
import com.tg5.domain.Role;
import com.tg5.repository.MemberRepository;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.MemberPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MembersController  extends BaseReadWriteController<MemberPayload, Member, Long> {

//    private final MemberRepository memberRepository;
//
//    public MembersController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    // TODO members CRUD
//    @GetMapping
//    public List<Member> getMembers() {
//        return memberRepository.findAll();
//    }

    // TODO [advanced] member roles CRUD /members/{memberId}/roles
//    @GetMapping("/{memberId}/roles")
//    public List<Role> getMemberRoles(@PathVariable Long memberId) {
//        Member byId = memberRepository.findById(memberId)
//                .orElseThrow();
//
//        return byId.getRoles();
//    }

    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance

    // TODO [advanced] calculate attendance single member, single event
    //      GET /members/{memberId}/events/{eventId}/attendance

}
