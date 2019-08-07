package com.opencart.api.strategies;

import com.opencart.api.OpenCartAPI;

public interface ProductAddingStrategy {
    void addMultipleProducts(OpenCartAPI openCartAPI, String productId, String quantity);
}
