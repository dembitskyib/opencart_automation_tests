package com.opencart.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.opencart.api.controllers.RequestController;
import io.qameta.allure.Step;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.opencart.environment.EnvironmentConstants.*;

public class OpenCartAPI {

    private static RequestSpecification requestSpecification;

    static {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setPort(Integer.valueOf(PORT))
                .build();
    }

    OpenCartAPI() {
        requestSpecification.queryParam("api_token", login());
    }


    @Step("Add product to cart")
    public Response addProductToCart(String productId, String quantity) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);
        return new RequestController(requestSpecification).post("api/cart/add", formParams);
    }

    @Step("Edit product quantity")
    public Response editProductQuantityInCart(String cartId, String quantity) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("key", cartId);
        formParams.put("quantity", quantity);
        return new RequestController(requestSpecification).post("api/cart/edit", formParams);
    }

    @Step("Remove product from cart")
    Response removeProductFromCart(String productId) {
        return new RequestController(requestSpecification)
                .post("api/cart/remove", Collections.singletonMap("key", productId));
    }

    @Step("Get products from cart")
    Response getProductsFromCart() {
        return new RequestController(requestSpecification).post("api/cart/products");
    }

    @Step("Log into account")
    private String login() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("username", API_USER_NAME);
        formParams.put("key", API_KEY);
        return new RequestController(requestSpecification)
                .post("api/login", formParams)
                .then().extract().path("api_token");
    }
}