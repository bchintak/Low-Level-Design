package com.design_patterns.creational.factory_method;

public class PushNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Push Notification Sent");
    }

}
