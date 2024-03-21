package com.tg5.integration.controller;

import com.tg5.integration.BaseIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SessionsControllerIntegrationTest extends BaseIntegrationTest {

    @Test
    public void test() {
        given()
                .log().all()
                .when()
                .get("events/{eventId}/sessions")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200)
        ;
    }

//    @Test
//    public void test() {
//        Long eventId = 12345L; // Example event ID
//        given().
//                pathParam("eventId", eventId). // Set the eventId path parameter
//                when().
//                get("/event/{eventId}/attendance").
//                then().
//                statusCode(200).
//                // Add your assertions here
//                        body("...", equalTo("..."));
//    }
}
