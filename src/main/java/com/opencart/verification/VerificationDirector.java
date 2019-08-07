package com.opencart.verification;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.opencart.verification.commands.ContentTypeVerificationCommand;
import com.opencart.verification.commands.ContentVerificationCommand;
import com.opencart.verification.commands.StatusCodeVerificationCommand;
import org.apache.http.HttpStatus;

public class VerificationDirector {
    private VerificationBuilder verificationBuilder;

    public VerificationDirector() {
        verificationBuilder = new VerificationBuilder();
    }

    public ResponseVerification createVerification(ContentVerificationCommand contentVerificationCommand, Response response) {
        return verificationBuilder
                .setStatusCodeVerificationCommand(new StatusCodeVerificationCommand(HttpStatus.SC_OK))
                .setContentTypeVerificationCommand(new ContentTypeVerificationCommand(ContentType.JSON))
                .setContentVerificationCommand(contentVerificationCommand)
                .setResponse(response)
                .build();
    }
}
