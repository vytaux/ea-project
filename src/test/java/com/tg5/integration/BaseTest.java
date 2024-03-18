package com.tg5.integration;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/v1/badge-system";
    }
}
