package com.tg5.service.reports;

import jakarta.servlet.http.HttpServletResponse;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@Qualifier("json")
public class JSONAttendanceExportService implements AttendanceExportService {
    @Override
    public HttpServletResponse setHeaders(HttpServletResponse response, String filename) {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + filename + "_" + currentDateTime + ".json";
        response.setHeader(headerKey, headerValue);
        return response;
    }

    @Override
    public void writeData(HttpServletResponse response, Map<String, Double> attendancesPerEvent) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, Double> entry : attendancesPerEvent.entrySet()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", entry.getKey());
            jsonObject.put("attendance", entry.getValue());
            jsonArray.add(jsonObject);
        }
        String content = jsonArray.toString();
        response.getWriter().write(content);
    }

}
