package com.opencart.verification.commands;

import com.jayway.restassured.response.Response;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;


public class ContentVerificationCommand implements VerificationCommand {
    private SoftAssert softAssert;
    private Map<String, Matcher> pathMatch;

    public ContentVerificationCommand() {
        pathMatch = new HashMap<>();
        softAssert = new SoftAssert();
    }

    public void addContentVerification(String path, Matcher expectedMatch) {
        pathMatch.put(path, expectedMatch);
    }

    @Override
    @Step("Verify response data correctness")
    public void verify(Response response) {
        pathMatch.forEach((path, expectedMatch) -> {
            try {
                response.then().assertThat().body(path, expectedMatch);
            } catch (AssertionError assertionError) {
                softAssert.fail(assertionError.getMessage());
            }
        });
        softAssert.assertAll();
    }
}
