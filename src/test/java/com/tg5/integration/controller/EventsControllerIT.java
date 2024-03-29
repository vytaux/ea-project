package com.tg5.integration.controller;

import com.tg5.integration.BaseIT;
import com.tg5.service.contract.EventPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class EventsControllerIT extends BaseIT {

    @Test
    public void testFindAll() {
        // prepare
        int savedId = createEvent("2024-01-01T00:00", "2024-01-13T00:00");

        // test
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                    .get("/events?fetch-all=true")
                .then()
                    .log().body()
                    .statusCode(200)
                    .body("id", hasItems(savedId));

        // teardown
        deleteEvent(savedId);
    }

    @Test
    public void testEventIsCreated() {
        // prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("new-event");

        // test
        Response response = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                .post("/events")
                .then()
                .statusCode(200)
                .body("name", equalTo(eventPayload.getName()))
                .extract().response();

        // teardown
        deleteEvent(response.jsonPath().getInt("id"));
    }

    @Test
    public void testEventIsUpdated() {
        // prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("new-event");

        int savedId = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .statusCode(200)
                    .body("name", equalTo(eventPayload.getName()))
                    .extract().jsonPath().getInt("id");

        EventPayload updatedEventPayload = new EventPayload();
        updatedEventPayload.setId((long) savedId);
        updatedEventPayload.setName("updated-event");

        // test
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(updatedEventPayload)
                .when()
                .put("/events/" + savedId)
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(updatedEventPayload.getName()));


        // teardown
        deleteEvent(savedId);
    }

    @Test
    public void testEventIsDeleted() {
        // Prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("event-to-delete");

        // Post new EventPayload and get its id
        int id = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .statusCode(200)
                    .extract().jsonPath().getInt("id");

        // Delete the event
        given()
                .when()
                    .delete("/events/" + id)
                .then()
                    .statusCode(200);

        // Verify the event is deleted
        given()
                .when()
                    .get("/events/" + id)
                .then()
                    .statusCode(404);
    }
}