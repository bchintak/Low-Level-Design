package com.design_patterns.structural.bridge;

public class SMSNotification
        extends Notification {

    public SMSNotification(
            NotificationProvider provider) {

        super(provider);
    }

    @Override
    public void send(String message) {

        provider.sendMessage(
                "[SMS] " + message);
    }
}