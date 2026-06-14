package com.fooddelivery.observer;

public class CustomerNotification
        implements Observer {

    @Override
    public void update(String message) {

        System.out.println(
                "Customer Notification : "
                        + message
        );
    }
}