package com.design_patterns.creational.factory_method;

public class Main {

    public static void main(String[] args) {

        Notification notification =
                NotificationFactory.createNotification("EMAIL");

        notification.send();
    }

}
