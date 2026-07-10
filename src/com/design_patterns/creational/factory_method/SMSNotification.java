package com.design_patterns.creational.factory_method;

public class SMSNotification implements Notification {

    @Override
    public void send() {
        System.out.println("SMS Sent");
    }

}
