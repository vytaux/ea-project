package com.tg5.integration.controller;

import com.tg5.integration.BaseIT;
import com.tg5.service.contract.EventPayload;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class EventsControllerIT extends BaseIT {

    @Test
    public void testFindAll() {
        // prepare
        EventPayload eventPayload = new EventPayload();

        Integer savedId = given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .log().body()
                    .statusCode(200)
                    .extract()
                    .path("id");

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
    }

    @Test
    public void testEventIsCreated() {
        // prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("new-event");

        // test
        given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .statusCode(200)
                    .body("name", equalTo(eventPayload.getName()));
    }

    @Test
    public void testEventIsUpdated() {
        // prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("new-event");

        Integer savedId = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .statusCode(200)
                    .body("name", equalTo(eventPayload.getName()))
                    .extract()
                    .path("id");

        EventPayload updatedEventPayload = new EventPayload();
        updatedEventPayload.setId(savedId.longValue());
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
    }

    @Test
    public void testEventIsDeleted() {
        // Prepare
        EventPayload eventPayload = new EventPayload();
        eventPayload.setName("event-to-delete");

        // Post new EventPayload and get its id
        Integer id = given()
                .contentType(ContentType.JSON)
                .body(eventPayload)
                .when()
                    .post("/events")
                .then()
                    .statusCode(200)
                    .extract()
                    .path("id");

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