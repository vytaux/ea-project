package com.tg5.integration.controller;

import com.tg5.integration.BaseIntegrationTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountsControllerIntegrationTest extends BaseIntegrationTest {
    private static Integer createdAccountId;

    @Test
    //@Order(1)
    public void testCreateAccount() {
        Response response = given()      // Storing response of Account creation for further processing
                .contentType(ContentType.JSON)
                .body("{\"name\": \"accountName\", \"description\": \"accountDescription\"}")
                .when()
                .post("/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response();
        createdAccountId = response.path("id");  // Getting the newly created account
        if (createdAccountId != null) {             // If the account found delete it
            given()
                    .when()
                    .delete("/accounts/" + createdAccountId)
                    .then()
                    .statusCode(200);
        } else {                                       // If can not delete the account mark it as a failure
            throw new AssertionError("Wrap up: DeleteTest failed because condition is false!" );
        }
    }

    @Test
    //@Order(2)
    public void testReadAccounts() {                    //Read the list of all accounts
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
    //@Order(3)
    public void testUpdateAccount() {
        Response response = given()      // Storing response of Account creation for further processing
                .contentType(ContentType.JSON)
                .body("{\"name\": \"accountName\", \"description\": \"accountDescription\"}")
                .when()
                .post("/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response();
        createdAccountId = response.path("id");  // Getting the newly created account
        // Ensure that testCreateAccount test created an account we are updating that
        if (createdAccountId != null) {
            given()
                    .contentType(ContentType.JSON)
                    .body("{\"id\":\""+createdAccountId+"\",\"name\": \"updatedAccount\", \"description\": \"updatedAccountDescription\"}")
                    .when()
                    .put("/accounts/"+createdAccountId) // Modify the ID according to your scenario
                    .then()
                    .statusCode(200);
            given()                     // Deleting the updated account
                    .when()
                    .delete("/accounts/" + createdAccountId)
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Wrap up: Update Test failed because condition is false!");
        }
    }
    @Test
    //@Order(4)
    public void testDeleteAccount() {
        Response response = given()      // Storing response of Account creation for further processing
                .contentType(ContentType.JSON)
                .body("{\"name\": \"accountName\", \"description\": \"accountDescription\"}")
                .when()
                .post("/accounts")
                .then()
                .statusCode(200)
                .extract()
                .response();
        createdAccountId = response.path("id");  // Getting the newly created account
        // Ensure that testCreateAccount test created an account
        if (createdAccountId != null) {
            given()
                    .when()
                    .delete("/accounts/" + createdAccountId)
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Wrap up: DeleteTest failed because condition is false!");
        }
    }
}
