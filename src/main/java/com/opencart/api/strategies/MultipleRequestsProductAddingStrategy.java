package com.opencart.api.strategies;

import com.opencart.api.OpenCartAPI;

import java.util.stream.IntStream;

public class MultipleRequestsProductAddingStrategy implements ProductAddingStrategy {
    @Override
    public void addMultipleProducts(OpenCartAPI openCartAPI, String productId, String quantity) {
        IntStream.rangeClosed(1, Integer.valueOf(quantity))
                .forEach(i -> openCartAPI.addProductToCart(productId, "1"));
    }
}
