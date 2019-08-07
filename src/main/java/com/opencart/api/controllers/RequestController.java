package com.opencart.api.controllers;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.opencart.allure.AllureAttachmentController;

import java.util.Collections;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RequestController {

    private RequestSpecification requestSpecification;

    public RequestController(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response post(String route) {
        return post(route, Collections.emptyMap());
    }

    public Response post(String route, Map<String, ?> formParams) {
        Response response = given()
                .specification(requestSpecification)
                .queryParam("route", route)
                .formParameters(formParams)
                .when()
                .post()
                .then()
                .extract().response();
        AllureAttachmentController.attachJsonResponse("response", response);
        return response;
    }

}
