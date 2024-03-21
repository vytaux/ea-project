package com.tg5.integration.controller;

import com.tg5.integration.BaseIntegrationTest;
import com.tg5.service.contract.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttendanceControllerIntegrationTest extends BaseIntegrationTest {

    @BeforeEach
    public void setup() {
        int memberId = createMember();
        int eventId = createEvent();
        int sessionId = createSession(eventId);
        int accountTypeId = createAccountType();
        createMemberRegistration(eventId, memberId, accountTypeId);
        int scannerId = createScanner();
        createRecord(memberId, sessionId, scannerId);
    }

    @Test
    public void testGetMemberEventAttendanceByAccountTypeAndDate() {
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

        assertEquals("2024-01-01T00:00:00", response.jsonPath().getString("fromDate"));
        assertEquals("2024-12-31T23:59:59", response.jsonPath().getString("toDate"));
        assertEquals("student", response.jsonPath().getString("accountType"));

        Map<Object, Object> attendanceData = response.jsonPath().getMap("attendancePercent");
        System.out.println(attendanceData);

        assertEquals(100.00, (float) attendanceData.get("john doe"));
    }

    private static int createScanner() {
        ScannerPayload scannerPayload = new ScannerPayload();
        scannerPayload.setScannerCode("someScannerCode");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(scannerPayload)
                .when()
                .post("/scanners")
                .then()
                .extract()
                .response();

        System.out.println(response.getBody().asString());

        return response.jsonPath().getInt("id");
    }

    private static void createRecord(int memberId, int sessionId, int scannerId) {
        RecordPayload recordPayload;
        MemberPayload memberPayload;
        SessionPayload sessionPayload;

        recordPayload = new RecordPayload();
        memberPayload = new MemberPayload();
        memberPayload.setId((long) memberId);
        recordPayload.setMember(memberPayload);

        sessionPayload = new SessionPayload();
        sessionPayload.setId((long) sessionId);
        recordPayload.setSession(sessionPayload);

        ScannerPayload scannerPayload = new ScannerPayload();
        scannerPayload.setId((long) scannerId);
        recordPayload.setScanner(scannerPayload);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(recordPayload)
                .when()
                .post("/scanners/someScannerCode/records")
                .then()
                .extract()
                .response();

        System.out.println(response.getBody().asString());
    }

    private static void createMemberRegistration(int eventId, int memberId, int accountTypeId) {
        EventPayload eventPayload;
        MemberPayload memberPayload;

        eventPayload = new EventPayload();
        eventPayload.setId((long) eventId);
        memberPayload = new MemberPayload();
        memberPayload.setId((long) memberId);
        eventPayload.setMembers(List.of(memberPayload));
        AccountTypePayload accountTypePayload = new AccountTypePayload();
        accountTypePayload.setId((long) accountTypeId);
        eventPayload.setAccountType(accountTypePayload);
        eventPayload.setStartDateTime(LocalDate.parse("2024-02-02").atTime(12, 0));
        eventPayload.setEndDateTime(LocalDate.parse("2024-09-30").atTime(12, 0));

        Response response = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                .put("/events/" + eventId)
                .then()
                .extract()
                .response();

        System.out.println(response.getBody().asString());
    }

    private static int createSession(int eventId) {
        Response response;
        EventPayload eventPayload;
        SessionPayload sessionPayload;

        sessionPayload = new SessionPayload();
        eventPayload = new EventPayload();
        eventPayload.setId((long) eventId);
        sessionPayload.setEvent(eventPayload);

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(sessionPayload)
                .when()
                .post("/events/" + eventId + "/sessions")
                .then()
                .extract()
                .response();

        return response.jsonPath().getInt("id");
    }

    private static int createEvent() {
        EventPayload eventPayload;
        Response response;

        eventPayload = new EventPayload();
        eventPayload.setName("Test Event");

        response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                .post("/events")
                .then()
                .extract()
                .response();

        return response.jsonPath().getInt("id");
    }

    private static int createMember() {
        Response response;
        MemberPayload memberPayload;

        memberPayload = new MemberPayload();
        memberPayload.setFirstname("john");
        memberPayload.setLastname("doe");

        response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(memberPayload)
                .when()
                .post("/members")
                .then()
                .log().all()
                .extract()
                .response();

        return response.jsonPath().getInt("id");
    }

    private static int createAccountType() {
        AccountTypePayload accountTypePayload = new AccountTypePayload();
        accountTypePayload.setName("student");

        Response response = RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(accountTypePayload)
                .when()
                .post("/account-types")
                .then()
                .log().all()
                .extract()
                .response();

        return response.jsonPath().getInt("id");
    }
}