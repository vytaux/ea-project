package com.tg5.integration.controller;

import com.tg5.domain.Location;
import com.tg5.domain.LocationType;
import com.tg5.integration.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocationsControllerTest extends BaseTest {
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
    public void deleteLocationById() {
        // Assuming you have a location with ID 1 in your system
        int locationIdToDelete = 5;

        // Optionally, verify the location exists before attempting to delete
        given()
                .log().all()
                .when()
                .get("/locations/" + locationIdToDelete)
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);

        // Now, delete the location
        given()
                .log().all()
                .when()
                .delete("/locations/" + locationIdToDelete)
                .then()
                .log().body()
                .statusCode(200); // Adjust the status code as per your API's response for a successful delete

        // Optionally, verify the location has been deleted
        given()
                .log().all()
                .when()
                .get("/locations/" + locationIdToDelete)
                .then()
                .log().body()
                .statusCode(404); // Assuming your API returns a 404 for a non-existent location
    }


            @Test
            public void addLocation() {
                // Sample data for the new location
                String locationName = "New Location";
                String locationType = "RESTAURANT"; // Replace with a valid enum value from your LocationType

                // Create a new location
                Response response = given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .body("{\"name\": \"" + locationName + "\", \"locationType\": \"" + locationType + "\"}")
                        .when()
                        .post("/locations")
                        .then()
                        .log().body()
                        .statusCode(200) // Expecting status code 200 for a successful operation
                        .extract()
                        .response();

                // Extract the created location ID as Integer
                Integer createdLocationId = response.path("id");
                assertNotNull("Location ID should not be null", String.valueOf(createdLocationId));

                // Optional: additional validation steps can be added here, such as verifying the content of the response

                // Optional cleanup: delete the created location
                given()
                        .when()
                        .delete("/locations/" + createdLocationId)
                        .then()
                        .statusCode(200); // Assuming 200 is the status code for successful deletion
            }
        }




