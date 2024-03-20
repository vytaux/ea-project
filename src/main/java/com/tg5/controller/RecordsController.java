package com.tg5.controller;


import com.tg5.service.contract.RecordPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tg5.domain.Record;

@RestController
@RequestMapping("/scanners/{scannerCode}/records")
public class RecordsController extends BaseReadWriteController<RecordPayload, Record, Long> {
}
