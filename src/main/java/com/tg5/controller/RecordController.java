package com.tg5.controller;


import com.tg5.service.contract.MemberPayload;
import com.tg5.service.contract.RecordPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tg5.domain.Record;

@RestController
@RequestMapping("/records")
public class RecordController extends BaseReadWriteController<RecordPayload, Record, Long> {



}
