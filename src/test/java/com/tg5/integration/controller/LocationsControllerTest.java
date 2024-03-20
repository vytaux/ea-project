package com.tg5.integration.controller;

import com.tg5.integration.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LocationsControllerTest extends BaseTest {
    @Test
    public void testGetAll() {
        given()
                .log().all()
                .when()
                .get("/locations")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
}
