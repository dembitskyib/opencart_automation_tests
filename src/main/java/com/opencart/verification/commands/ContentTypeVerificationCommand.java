package com.opencart.verification.commands;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class ContentTypeVerificationCommand implements VerificationCommand {
    private ContentType contentType;

    public ContentTypeVerificationCommand(ContentType contentType) {
        this.contentType = contentType;
    }

    @Override
    @Step("Verify response content type")
    public void verify(Response response) {
        Allure.addAttachment("Actual Content Type", response.contentType());
        Allure.addAttachment("Expected Content Type", contentType.toString());
        response.then().assertThat().contentType(contentType);
    }
}
