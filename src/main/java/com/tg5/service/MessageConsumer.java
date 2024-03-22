package com.tg5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    private EmailService emailService;

    @JmsListener(destination = "ams")
    public void receiveMessage(String message) {                //receiving a message
        System.out.println("Received message: " + message);     //Debug message for demo
        String[] parts = message.split("#");             //Spiriting the message to get receiver, subject and body
        if (parts.length == 3){
            emailService.sendEmail(parts[0], parts[1], parts[2]);   //Sending mail
        }
    }
}
