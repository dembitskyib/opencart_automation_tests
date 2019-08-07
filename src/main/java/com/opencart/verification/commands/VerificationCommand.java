package com.opencart.verification.commands;

import com.jayway.restassured.response.Response;

public interface VerificationCommand {
    void verify(Response response);

}
