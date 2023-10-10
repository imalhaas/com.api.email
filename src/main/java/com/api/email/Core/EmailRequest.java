package com.api.email.Core;

public record EmailRequest(String to, String subject, String body) {
}
