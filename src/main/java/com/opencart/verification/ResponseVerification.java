package com.opencart.verification;

import com.opencart.verification.commands.VerificationCommand;
import com.jayway.restassured.response.Response;

import java.util.List;

public class ResponseVerification {
    private List<VerificationCommand> commands;
    private Response response;

    ResponseVerification(List<VerificationCommand> commands, Response response) {
        this.commands = commands;
        this.response = response;
    }

    public void verifyAll() {
        commands.forEach(command -> command.verify(response));
    }
}
