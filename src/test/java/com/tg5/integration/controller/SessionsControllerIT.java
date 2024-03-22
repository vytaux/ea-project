package com.tg5.integration.controller;

import com.tg5.integration.BaseIT;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class SessionsControllerIT extends BaseIT {

    @Test
    public void test() {
        given()
                .log().all()
                .when()
                .get("events/1/sessions")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    public void testUpdateSession() {
        //  create a session to update


        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"sessionName\", \"startDateTime\": \"2024-03-20 09:00\", \"endDateTime\": \"2024-03-20 10:00\"}")
                .when()
                .post("/events/1/sessions")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Integer createdSessionId = response.path("id");

        if (createdSessionId != null) {
            //  update the session
            // \"id\":\""+createdAccountId+"\",
            given()
                    .contentType(ContentType.JSON)
                    .body("{\"id\":\"" + createdSessionId + "\",\"name,\": \"sessionName\", \"startDateTime\": \"2024-03-20 09:00\", \"endDateTime\": \"2024-03-20 10:00\"}")
                    .when()
                    .put("/events/1/sessions/" + createdSessionId) // Update with your event ID and session ID
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Failed to create session for update test!");
        }
    }


    @Test
    public void testCreateSession() {
        // Request body for creating a session
        String requestBody = "{\"name\": \"sessionName\", \"startDateTime\": \"2024-03-20 09:00\", \"endDateTime\": \"2024-03-20 10:00\"}";

        // Sending POST request to create a session
        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/events/1/sessions")
                .then()
                .statusCode(200) // Expecting status code 201 for successful creation
                .body("id", notNullValue()) // Expecting the response to contain a non-null session ID
                .body("name", equalTo("sessionName")); // Expecting the response to contain the correct session name
    }

    //}
    @Test
    public void testDeleteSession() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{\"name\": \"sessionName\", \"startDateTime\": \"2024-03-20 09:00\", \"endDateTime\": \"2024-03-20 10:00\"}")
                .when()
                .post("/events/1/sessions")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Integer createdSessionId = response.path("id");

        // Sending DELETE request to delete the session
        given()
                .when()
                .delete("/events/1/sessions/" + createdSessionId) // Update with your event ID and session ID
                .then()
                .statusCode(200); // Expecting status code 200 for successful deletion
    }
}

