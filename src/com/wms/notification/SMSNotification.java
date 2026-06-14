package com.wms.notification;

public class SMSNotification implements NotificationService {

    @Override
    public void send(String recipient, String message) {
        System.out.println(
                "Sending SMS to " + recipient +
                        " : " + message
        );
    }
}