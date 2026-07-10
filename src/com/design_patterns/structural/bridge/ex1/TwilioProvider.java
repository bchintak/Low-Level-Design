package com.design_patterns.structural.bridge.ex1;

public class TwilioProvider
        implements NotificationProvider {

    @Override
    public void sendMessage(
            String message) {

        System.out.println(
                "Twilio: " + message);
    }
}
