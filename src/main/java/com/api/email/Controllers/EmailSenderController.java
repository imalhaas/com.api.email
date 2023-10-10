package com.api.email.Controllers;

import com.api.email.Application.EmailSenderService;
import com.api.email.Core.EmailRequest;
import com.api.email.Core.Exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailrequest){
        try{
            this.emailSenderService.sendEmail(emailrequest.to(), emailrequest.subject(), emailrequest.body());
            return ResponseEntity.ok("Email Sent successfully!");
        }catch (EmailServiceException ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending faleid");
        }


    }
}
