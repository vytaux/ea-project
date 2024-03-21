package com.tg5.integration.controller;

import com.tg5.domain.Location;
import com.tg5.domain.LocationType;
import com.tg5.integration.BaseIntegrationTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LocationsControllerTest extends BaseIntegrationTest {
    @Test
    public void testGetAll() {
        given()
                .log().all()
                .when()
                .get("/locations")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
@Test
    public void testUpdateLocation() {
        // Sample data for creating and updating a location
        String initialName = "ARGIRO ROCKS!";
        String initialType = "DINING_HALL"; // Replace with valid enum value from LocationType
        String updatedName = "ARGIRO!!";
        String updatedType = "DINING_HALL"; // Replace with valid enum value from LocationType
         Location location = new Location();
         location.setName(initialName);
         location.setLocationType(LocationType.valueOf(initialType));

        // Create a new location
        Response response = given()
                .contentType(ContentType.JSON)
                .body(location)
                .when()
                .post("/locations")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Integer newLocationId = response.path("id"); // Extract the created location ID

        // Ensure a location was created before attempting to update
        if (newLocationId != null) {
            // Update the location
            location.setName(updatedName);
            location.setLocationType(LocationType.valueOf(updatedType));
            location.setId(Long.valueOf(newLocationId));

            given()
                    .contentType(ContentType.JSON)
                    .body(location)
                    .when()
                    .put("/locations/" + newLocationId)
                    .then()
                    .statusCode(200);

            // Optional: Deleting the updated location as cleanup
            given()
                    .when()
                    .delete("/locations/" + newLocationId)
                    .then()
                    .statusCode(200);
        } else {
            throw new AssertionError("Update Test failed: No location was created.");
        }
    }



    @Test
    public void deletelocationbyid() {
        given()
                .log().all()
                .when()
                .get("/locations/1")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }
}


