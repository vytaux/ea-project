package com.tg5.integration.controller;

import com.tg5.domain.Role;
import com.tg5.integration.BaseIT;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RolesControllerIT extends BaseIT {

    @Test
    public void testGet() {
        given()
                .log().all()
                .when()
                .get("/roles")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200)
        ;
    }
    @Test
    public void testPost() {
        // add a role
        Role role = new Role();
        role.setName("student");
        given()
                .contentType("application/json")
                .body(role)
                .when().post("/roles").then()
                .statusCode(200);
    }
}
