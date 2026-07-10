package com.design_patterns.creational.factory_method;

public class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Email Sent");
    }

}
