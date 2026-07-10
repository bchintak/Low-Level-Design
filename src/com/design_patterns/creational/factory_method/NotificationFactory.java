package com.design_patterns.creational.factory_method;

public class NotificationFactory {

    public static Notification createNotification(String type){

        if(type.equalsIgnoreCase("EMAIL")){
            return new EmailNotification();
        }

        if(type.equalsIgnoreCase("SMS")){
            return new SMSNotification();
        }

        if(type.equalsIgnoreCase("PUSH")){
            return new PushNotification();
        }

        throw new IllegalArgumentException("Invalid Type");
    }

}
