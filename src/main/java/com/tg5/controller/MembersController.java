package com.tg5.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController {
    // TODO members CRUD
    // TODO [advanced] member roles CRUD /members/{memberId}/roles
    // TODO [advanced] calculate attendance GET /members/{memberId}/attendance
    // TODO [advanced] calculate attendance single member, single event
    //      GET /members/{memberId}/events/{eventId}/attendance
}
