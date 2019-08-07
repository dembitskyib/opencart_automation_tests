package com.opencart.verification.commands;

import com.jayway.restassured.response.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class StatusCodeVerificationCommand implements VerificationCommand {
    private int statusCode;

    public StatusCodeVerificationCommand(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    @Step("Verify response status code")
    public void verify(Response response) {
        Allure.addAttachment("Actual Status Code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Expected Status Code", String.valueOf(statusCode));
        response.then().assertThat().statusCode(statusCode);
    }
}
