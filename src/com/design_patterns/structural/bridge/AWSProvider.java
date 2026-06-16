package com.design_patterns.structural.bridge;

public class AWSProvider
        implements NotificationProvider {

    @Override
    public void sendMessage(
            String message) {

        System.out.println(
                "AWS: " + message);
    }
}
