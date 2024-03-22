package com.tg5.service.reports;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@Qualifier("excel")
public class ExcelAttendanceExportService implements AttendanceExportService {
    private Worksheet worksheet;
    private Workbook workbook;

    @Override
    public HttpServletResponse setHeaders(HttpServletResponse response, String filename) {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + filename + "_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        return response;
    }

    @Override
    public void writeData(HttpServletResponse response, Map<String, Double> attendancesPerEvent) throws IOException {
        String[] headers = new String[]{"No", "Member", "Attendance"};

        writeTableHeaderExcel(response.getOutputStream(), "Sheet Attendance", "Report Attendance", "attendance title", headers);
        writeTableData(attendancesPerEvent);
        workbook.close();
        response.getOutputStream().close();
    }

    private void writeTableHeaderExcel(ServletOutputStream outputStream, String workName, String sheetName, String titleName, String[] headers) {
        workbook = new Workbook(outputStream, workName, "1.0");
        worksheet = workbook.newWorksheet(sheetName);

        for (int i = 0; i < headers.length; i++) {
            worksheet.value(0, i, headers[i]);
        }
    }

    private void writeTableData(Map<String, Double> data) {

        int row = 1;
        int col = 0;
        // write content
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            worksheet.value(row, col++, row);
            worksheet.value(row, col++, entry.getKey());
            worksheet.value(row, col, entry.getValue());
            row++;
            col = 0;
        }
    }
}
