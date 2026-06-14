package com.wms.notification;

public class EmailNotification implements NotificationService {

    @Override
    public void send(String recipient, String message) {
        System.out.println(
                "Sending EMAIL to " + recipient +
                        " : " + message
        );
    }
}