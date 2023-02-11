package com.belezanaweb;

import com.belezanaweb.util.ResourceUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BelezanawebIT {

    @LocalServerPort
    private int port;

    @Autowired
    private Flyway flyway;

    private String correctJson;
    private String jsonWithId;

    @BeforeEach
    public void setUp() {
        RestAssured.basePath = "/products";
        RestAssured.port = port;
        getJsons();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        flyway.migrate();
    }

    private void getJsons() {
        correctJson = ResourceUtils.getContentFromResource("/json/correctBody.json");
        jsonWithId = ResourceUtils.getContentFromResource("/json/jsonWithCorrectId.json");
    }

    @Test
    public void shouldFail_WhenRegisterExistingProduct() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonWithId).when()
                .post().then().statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void shouldReturnStatus201Created_WhenToAddProduct() {
        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(correctJson).when()
                .post().then().statusCode(HttpStatus.CREATED.value()).log().all();
    }

}
