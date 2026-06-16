package com.design_patterns.structural.bridge;

public class Main {

    public static void main(String[] args) {

        Notification notification =
                new EmailNotification(
                        new AWSProvider());

        notification.send(
                "Order Delivered");
    }
}
