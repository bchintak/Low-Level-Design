package com.design_patterns.structural.bridge.ex1;

public class EmailNotification
        extends Notification {

    public EmailNotification(
            NotificationProvider provider) {

        super(provider);
    }

    @Override
    public void send(String message) {

        provider.sendMessage(
                "[EMAIL] " + message);
    }
}
