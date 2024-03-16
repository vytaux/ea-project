package com.tg5.controller;

import com.tg5.domain.Event;
import com.tg5.domain.Scanner;
import com.tg5.repository.ScannerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scanners")
public class ScannersController {

    private final ScannerRepository scannerRepository;

    public ScannersController(ScannerRepository scannerRepository) {
        this.scannerRepository = scannerRepository;
    }

    // TODO scanners CRUD
    @RequestMapping
    public List<Scanner> getScanners() {
        return scannerRepository.findAll();
    }
    // [advanced] scanner records CRUD /scanners/{scannerCode}/records
}
