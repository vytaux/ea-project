package com.tg5.integration.controller;


import com.tg5.integration.BaseIT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScannersControllerTest extends BaseIT {
    private static Integer createdScannerId;

    @Test
    @Order(1)
    public void testCreateScanner() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"scannerCode\": \"SC123\", \"name\": \"ScannerName\"}").when()
                .post("/scanners")
                .then()
                .statusCode(200)
                .extract()
                .response();
        createdScannerId = response.path("id");
    }

    @Test
    @Order(2)
    public void testReadScanners() {
        given()
                .log().all()
                .when()
                .get("/scanners")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    @Order(3)
    public void testUpdateScanner() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\":\"" + createdScannerId + "\",\"scannerCode\": \"updatedScannerCode\", \"name\": \"updatedScannerName\"}") // adjust the properties accordingly
                .when()
                .put("/scanners/" + createdScannerId)
                .then()
                .statusCode(200);
    }


    @Test
    @Order(4)
    public void testDeleteScanner() {
        if (createdScannerId != null) {
            given()
                    .when()
                    .delete("/scanners/" + createdScannerId)
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Delete Test failed because condition is false!" + createdScannerId);
        }
    }
}