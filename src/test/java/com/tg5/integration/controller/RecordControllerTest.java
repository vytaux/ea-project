package com.tg5.integration.controller;

import com.tg5.integration.BaseTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import com.tg5.domain.Record;
import static io.restassured.RestAssured.given;
public class RecordControllerTest extends BaseTest {

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
