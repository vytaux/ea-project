package com.tg5.service.reports;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public interface AttendanceExportService {

    HttpServletResponse setHeaders(HttpServletResponse response, String filename);

    void writeData(HttpServletResponse outputStream, Map<String, Double> attendancesPerEvent) throws IOException;
}
