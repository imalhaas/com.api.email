package com.api.email.Core;

public interface EmailSenderUseCase {// representa a,logica de negocio

    void sendEmail(String to, String subject, String body);
}
