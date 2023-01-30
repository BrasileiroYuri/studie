package com.belezanaweb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import com.belezanaweb.api.controller.ProductController;
import com.belezanaweb.util.ResourceUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BelezanawebIT {

	@LocalServerPort
	private int port;

	@Autowired
	ProductController productController;
	@Autowired
	ResourceUtils resourceUtils;

	private String payloadJson;

	@BeforeEach
	public void setUp() {
		RestAssured.basePath = "/products";
		RestAssured.port = port;
		payloadJson = resourceUtils.getContentFromResource("/json/payloadJson.json");
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

	@Test
	public void deveRetornarStatus201Created_quandoAdicionarProduto() {
		RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payloadJson).when().post()
				.then().statusCode(HttpStatus.CREATED.value()).log().all();
	}
}
