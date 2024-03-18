package com.tg5.controller;

import com.tg5.domain.Account;
import com.tg5.domain.Scanner;
import com.tg5.repository.ScannerRepository;
import com.tg5.service.contract.AccountPayload;
import com.tg5.service.contract.ScannerPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scanners")
public class ScannersController extends BaseReadWriteController<ScannerPayload, Scanner, Long> {
}
