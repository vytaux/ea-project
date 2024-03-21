package com.tg5.integration.controller;

import com.tg5.domain.Member;
import com.tg5.integration.BaseIntegrationTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MembersControllerTest extends BaseIntegrationTest {

    @Test
    public void testGetAllMembers() {
        given()
                .log().all()
                .when()
                .get("/members")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .statusCode(200);
    }

    @Test
    public void testCreateMember() {
        Member member = new Member();
        member.setFirstname("Jean");
        member.setLastname("Claude");
        member.setEmail("gombaniro@miu.edu");

        // Create a new location
        Response response = given()
                .contentType(ContentType.JSON)
                .body(member)
                .when()
                .post("/members")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Integer newMemberId = response.path("id");
        Assertions.assertNotNull(newMemberId);
    }


    @Test
    public void updateMember() {
        Member member = new Member();
        member.setFirstname("Joe");
        member.setLastname("Doe");
        member.setEmail("joe@miu.edu");

        // Create a new location
        Response response = given()
                .contentType(ContentType.JSON)
                .body(member)
                .when()
                .post("/members")
                .then()
                .statusCode(200)
                .extract()
                .response();

        Integer newMemberId = response.path("id");
        Assertions.assertNotNull(newMemberId);

        member.setId(Long.valueOf(newMemberId));
        member.setEmail("newjoe@miu.edu");
        member.setFirstname("july");
        member.setLastname("layman");

        given()
                .contentType("application/json")
                .body(member)
                .when().put("/members/" + newMemberId).then()
                .statusCode(HttpStatus.OK.value());

        given()
                .when()
                .get("members/" + newMemberId)
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("firstname", equalTo("july"))
                .body("lastname", equalTo("layman"))
                .body("email", equalTo("newjoe@miu.edu"));
    }
}
