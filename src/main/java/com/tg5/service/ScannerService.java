package com.tg5.service;

import com.tg5.domain.Scanner;
import com.tg5.domain.Session;
import com.tg5.service.contract.ScannerPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface ScannerService extends BaseReadWriteService <ScannerPayload, Scanner, Long>{

}
