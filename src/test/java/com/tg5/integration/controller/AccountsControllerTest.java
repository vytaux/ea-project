package com.tg5.integration.controller;

import com.tg5.integration.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountsControllerTest extends BaseTest {
    private static Integer createdAccountId;

    @Test
    @Order(1)
    public void testCreateAccount() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"accountName\", \"description\": \"accountDescription\"}")
                .when()
                .post("/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response();
        createdAccountId = response.path("id");
    }

    @Test
    @Order(2)
    public void testReadAccounts() {
        given()
                .log().all()
                .when()
                .get("/accounts")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
    @Test
    @Order(3)
    public void testUpdateAccount() {
        // Ensure that testCreateAccount test created an account
        if (createdAccountId != null) {
            given()
                    .contentType(ContentType.JSON)
                    .body("{\"id\":\""+createdAccountId+"\",\"name\": \"updatedAccount\", \"description\": \"updatedAccountDescription\"}")
                    .when()
                    .put("/accounts/"+createdAccountId) // Modify the ID according to your scenario
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Update Test failed because condition is false!" + createdAccountId);
        }
    }
    @Test
    @Order(4)
    public void testDeleteAccount() {
        // Ensure that testCreateAccount test created an account
        if (createdAccountId != null) {
            given()
                    .when()
                    .delete("/accounts/" + createdAccountId)
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("DeleteTest failed because condition is false!" + createdAccountId);
        }
    }
}
