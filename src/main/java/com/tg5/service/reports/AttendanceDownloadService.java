package com.tg5.service.reports;

import com.tg5.service.AttendanceService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class AttendanceDownloadService {

    private final AttendanceService attendanceService;
    public XSSFSheet sheet;
    private XSSFWorkbook workbook;

    @Autowired
    public AttendanceDownloadService(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;

    }

    public HttpServletResponse export(HttpServletResponse response, Long eventId) throws IOException {
        Map<String, Double> attendancesPerEvent = attendanceService.getAttendanceByEventId(eventId);
        setHeaders(response, "attendances.xsl");
        ServletOutputStream outputStream = response.getOutputStream();
        String[] headers = new String[]{"No", "MemberID", "Attendance"};
        writeTableHeaderExcel("Sheet Attendance", "Report Attendance", headers);
        writeTableData(attendancesPerEvent);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return response;
    }

    public HttpServletResponse setHeaders(HttpServletResponse response, String filename) {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + filename + "_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        return response;
    }

    public void writeTableHeaderExcel(String sheetName, String titleName, String[] headers) {
         workbook = new XSSFWorkbook();
        // sheet
        sheet = workbook.createSheet(sheetName);
        org.apache.poi.ss.usermodel.Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(20);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);


        // title
        createCell(row, 0, titleName, style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headers.length - 1));
        font.setFontHeightInPoints((short) 10);

        // header
        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        for (int i = 0; i < headers.length; i++) {
            createCell(row, i, headers[i], style);
        }
    }

    public void createCell(org.apache.poi.ss.usermodel.Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    public CellStyle getFontContentExcel() {
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        return style;
    }

    public void writeTableData(Map<String, Double> data) {

        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, entry.getKey(), style);
            createCell(row, columnCount++, entry.getValue(), style);

        }
    }

}
