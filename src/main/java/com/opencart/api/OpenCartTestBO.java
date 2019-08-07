package com.opencart.api;

import com.jayway.restassured.response.Response;
import com.opencart.api.strategies.ProductAddingStrategy;

public class OpenCartTestBO implements OpenCartBO {

    public Response addItem(ProductAddingStrategy strategy, String productId, String quantity) {
        OpenCartAPI openCartAPI = new OpenCartAPI();
        strategy.addMultipleProducts(openCartAPI, productId, quantity);
        return openCartAPI.getProductsFromCart();
    }

    public Response removeCart() {
        OpenCartAPI openCartAPI = new OpenCartAPI();
        openCartAPI.addProductToCart("40", "1");
        String cartId = openCartAPI.getProductsFromCart().then().extract().path("products.cart_id[0]");
        openCartAPI.removeProductFromCart(cartId);
        return openCartAPI.getProductsFromCart();
    }

}
