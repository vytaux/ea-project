package com.tg5.service;

import com.tg5.domain.Scanner;
import com.tg5.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface ScannerService extends BaseReadWriteService<ScannerPayload, Scanner, Long> {
    // List<SessionPayload> getAttendanceForEvent(Long eventId);
}
