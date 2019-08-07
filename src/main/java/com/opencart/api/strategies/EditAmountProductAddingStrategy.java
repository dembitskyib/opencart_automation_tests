package com.opencart.api.strategies;

import com.opencart.api.OpenCartAPI;

public class EditAmountProductAddingStrategy implements ProductAddingStrategy {
    @Override
    public void addMultipleProducts(OpenCartAPI openCartAPI, String productId, String quantity) {
        openCartAPI.addProductToCart(productId, "1");
        openCartAPI.editProductQuantityInCart(productId, quantity);
    }
}
