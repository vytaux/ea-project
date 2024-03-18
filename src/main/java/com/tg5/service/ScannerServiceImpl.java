package com.tg5.service;

import com.tg5.domain.Scanner;
import com.tg5.domain.Session;
import com.tg5.service.contract.ScannerPayload;
import com.tg5.service.contract.SessionPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ScannerServiceImpl extends BaseReadWriteServiceImpl<ScannerPayload, Scanner, Long> implements ScannerService {

}
