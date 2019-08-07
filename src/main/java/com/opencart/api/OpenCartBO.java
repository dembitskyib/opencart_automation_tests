package com.opencart.api;

import com.jayway.restassured.response.Response;
import com.opencart.api.strategies.ProductAddingStrategy;

public interface OpenCartBO {
    Response addItem(ProductAddingStrategy strategy, String productId, String quantity);

    Response removeCart();
}
