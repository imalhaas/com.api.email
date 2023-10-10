package com.api.email.Adapters;

public interface EmailSenderGateway { //contrato para a aplicaçao interagir com o aws
    void sendEmail(String toEmail, String subject, String body);
}
