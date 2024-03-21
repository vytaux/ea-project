package com.tg5.service;

import com.tg5.domain.Event;
import com.tg5.domain.Scanner;
import com.tg5.service.contract.EventPayload;
import com.tg5.service.contract.ScannerPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long> implements ScannerService {
	
}
