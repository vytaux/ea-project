package com.tg5;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "your-queue-name")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
