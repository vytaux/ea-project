package com.tg5.service.reports;

import com.tg5.service.AttendanceService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class AttendanceDownloadService {

    private final AttendanceService attendanceService;

    private final AttendanceExportService excelAttendanceExportService;

    private final AttendanceExportService jsonAttendanceExportService;

    public AttendanceDownloadService(AttendanceService attendanceService,
                                     @Qualifier("excel") AttendanceExportService excelAttendanceExportService,
                                     @Qualifier("json") AttendanceExportService jsonAttendanceExportService) {
        this.attendanceService = attendanceService;
        this.excelAttendanceExportService = excelAttendanceExportService;
        this.jsonAttendanceExportService = jsonAttendanceExportService;
    }


    public HttpServletResponse export(HttpServletResponse response, HttpServletRequest request) throws IOException {
        Long eventId = Long.valueOf(request.getParameter("eventId"));
        String acceptType = request.getHeader("Accept");
        Map<String, Double> attendancesPerEvent = attendanceService.getAttendanceByEventId(eventId);
        AttendanceExportService processor = getExporter(acceptType);
        processor.setHeaders(response, "attendances");
        processor.writeData(response, attendancesPerEvent);
        return response;
    }

    private AttendanceExportService getExporter(String accept) {
        if (accept.contains("json")) {
            return jsonAttendanceExportService;
        } else if (accept.contains("excel")) {
            return excelAttendanceExportService;
        } else {
            throw new IllegalArgumentException("Not supported file format [only JSON and excel]");
        }
    }
}
