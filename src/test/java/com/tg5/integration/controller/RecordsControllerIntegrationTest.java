package com.tg5.integration.controller;

import com.tg5.integration.BaseIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class RecordsControllerIntegrationTest extends BaseIntegrationTest {

    @Test
    public void test() {
        given()
                .log().all()
                .when()
                .get("/records")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200)
        ;
    }
}
