package com.tg5.integration.controller;

import com.tg5.integration.BaseIT;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
public class RecordsControllerIT extends BaseIT {

    @Test
    public void test() {
        given()
                .log().all()
                .when()
                .get("/scanners/scannerCode/records")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200)
        ;
    }
}
