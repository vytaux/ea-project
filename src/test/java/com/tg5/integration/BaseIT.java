package com.tg5.integration;

import com.tg5.service.contract.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseIT {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080/v1/badge-system";
    }

    protected static int createScanner() {
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

    protected static int createRecord(int memberId, int sessionId, int scannerId) {
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

        return response.jsonPath().getInt("id");
    }

    protected static void createMemberRegistration(int eventId, int memberId, int accountTypeId) {
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

    protected static int createSession(int eventId) {
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

    protected static int createEvent() {
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

    protected static int createMember() {
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

    protected static int createAccountType() {
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

    protected void deleteRecord(int recordId) {
        given()
                .when()
                .delete("/scanners/someScannerCode/records/" + recordId)
                .then()
                .log().body()
                .statusCode(200);
    }

    protected void deleteScanner(int scannerId) {
        given()
                .log().all()
                .when()
                .delete("/scanners/" + scannerId)
                .then()
                .log().body()
                .statusCode(200);
    }

    protected void deleteMember(int memberId) {
        given()
                .log().all()
                .when()
                .delete("/members/" + memberId)
                .then()
                .log().body()
                .statusCode(200);
    }

    protected void deleteEvent(int eventId) {
        given()
                .log().all()
                .when()
                .delete("/events/" + eventId)
                .then()
                .log().body()
                .statusCode(200);
    }

    protected void deleteSession(int eventId, int sessionId) {
        given()
                .log().all()
                .when()
                .delete("/events/" + eventId  + "/sessions/" + sessionId)
                .then()
                .log().body()
                .statusCode(200);
    }
}
