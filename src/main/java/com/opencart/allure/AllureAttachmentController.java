package com.opencart.allure;

import com.jayway.restassured.response.Response;
import io.qameta.allure.Attachment;

public class AllureAttachmentController {

    @SuppressWarnings({"UnusedReturnValue", "unused"})
    @Attachment(value = "{name}", type = "application/json")
    public static String attachJsonResponse(String name, Response response) {
        return response.getBody().asString();
    }

}
