package com.tg5.controller;

import com.tg5.domain.Member;
import com.tg5.domain.Role;
import com.tg5.service.MemberService;
import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.RolePayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MemberPayload, Member, Long> {


    private  MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
//
//    // TODO members CRUD
//    @GetMapping
//    public List<Member> getMembers() {
//        return memberRepository.findAll();
//    }

    // TODO [advanced] member roles CRUD /members/{memberId}/roles
   @GetMapping("/{memberId}/roles")
    public ResponseEntity<?> getMemberRoles(@PathVariable Long memberId) {
        MemberPayload memberPayload = memberService.findById(memberId);
        return ResponseEntity.ok(memberPayload.getRoles());
    }

    @PostMapping("/{memberId}/roles")
    public ResponseEntity<?> addRole( @PathVariable Long memberId, @RequestBody RolePayload rolePayload) {
        MemberPayload memberPayload = memberService.findById(memberId);
        Role newRole = new Role();
        newRole.setId(rolePayload.getId());
        memberPayload.addRole(newRole);
        memberService.update(memberId, memberPayload);
        return ResponseEntity.ok(memberPayload);

    }

    @DeleteMapping("/{memberId}/roles/{roleId}")
    public ResponseEntity<?> deleteRole( @PathVariable Long memberId, @PathVariable Integer roleId) {
        MemberPayload memberPayload = memberService.findById(memberId);
        memberPayload.removeRole(roleId);
        memberService.update(memberId, memberPayload);
        return ResponseEntity.ok(memberPayload);
    }

    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance

    // TODO [advanced] calculate attendance single member, single event
    //      GET /members/{memberId}/events/{eventId}/attendance

}
