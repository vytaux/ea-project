package com.tg5.integration.controller;

import com.tg5.integration.BaseIT;
import com.tg5.service.contract.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttendanceControllerIT extends BaseIT {

    @Test
    public void testGetMemberEventAttendanceByAccountTypeAndDate() {
        // prepare
        int memberId = createMember();
        int eventId = createEvent("2024-02-02T12:00", "2024-09-30T12:00");
        int sessionId = createSession(eventId, "2024-02-03T10:00", "2024-02-03T12:00");
        int accountTypeId = createAccountType();
        createMemberRegistration(eventId, memberId, accountTypeId, "2024-02-02T12:00", "2024-09-30T12:00");
        int scannerId = createScanner();
        int recordId = createRecord(memberId, sessionId, scannerId, "2024-02-03T11:00");

        // test
        Response response = given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/accounts/student/attendance/2024-01-01/2024-12-31")
                .then()
                .log().body()
                .statusCode(200)
                .extract()
                .response();

        assertEquals("2024-01-01", response.jsonPath().getString("fromDate"));
        assertEquals("2024-12-31", response.jsonPath().getString("toDate"));
        assertEquals("student", response.jsonPath().getString("accountType"));

        Map<Object, Object> attendanceData = response.jsonPath().getMap("attendancePercentage");
        System.out.println(attendanceData);

        assertEquals(100.00, (float) attendanceData.get("john doe"));

        // teardown
        deleteRecord(recordId);
        deleteScanner(scannerId);
        deleteSession(eventId, sessionId);
        deleteEvent(eventId);
        deleteMember(memberId);
    }
}