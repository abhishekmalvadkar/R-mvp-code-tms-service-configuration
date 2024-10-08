package com.amalvadkar.tms.configuration.controllers;

import com.amalvadkar.tms.configuration.common.AbstractIT;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;


@Sql("/app-config-test-data.sql")
class AppConfigRestControllerTest  extends AbstractIT {

    @Test
    void should_return_app_config_key_value() {
        var requestPayload = """
                {
                    "category" : "GENERAL"
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .when()
                .post("/api/configuration/fetch-configs")
                .then()
                .body("data", is(notNullValue()))
                .body("data.siteLogo", is("url"))
                .body("data.siteTagLine", is("Helps To Manage Tasks"))
                .body("success", is(true))
                .body("code", is(200))
                .body("message", is("Fetched Successfully"));
    }
}