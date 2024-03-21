package com.tg5.controller;


import com.tg5.service.reports.AttendanceDownloadService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    private final AttendanceDownloadService attendanceDownloadService;

    @Autowired
    public ReportsController(AttendanceDownloadService attendanceDownloadService) {
        this.attendanceDownloadService = attendanceDownloadService;
    }

    @GetMapping("/attendance")
    public void exportToPdf(HttpServletResponse response, HttpServletRequest request) throws IOException {
        this.attendanceDownloadService.export(response, request);
    }

}
