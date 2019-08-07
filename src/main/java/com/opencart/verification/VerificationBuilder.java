package com.opencart.verification;

import com.jayway.restassured.response.Response;
import com.opencart.verification.commands.VerificationCommand;

import java.util.Arrays;
import java.util.List;

class VerificationBuilder {
    private Response response;
    private VerificationCommand contentVerificationCommand;
    private VerificationCommand statusCodeVerificationCommand;
    private VerificationCommand contentTypeVerificationCommand;

    VerificationBuilder setContentVerificationCommand(VerificationCommand verificationCommand) {
        contentVerificationCommand = verificationCommand;
        return this;
    }

    VerificationBuilder setStatusCodeVerificationCommand(VerificationCommand verificationCommand) {
        statusCodeVerificationCommand = verificationCommand;
        return this;
    }

    VerificationBuilder setContentTypeVerificationCommand(VerificationCommand verificationCommand) {
        contentTypeVerificationCommand = verificationCommand;
        return this;
    }

    public VerificationBuilder setResponse(Response response) {
        this.response = response;
        return this;
    }

    ResponseVerification build() {
        List<VerificationCommand> commands = Arrays.asList(
                statusCodeVerificationCommand,
                contentTypeVerificationCommand,
                contentVerificationCommand);
        return new ResponseVerification(commands, response);
    }

}
