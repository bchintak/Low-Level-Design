package com.fooddelivery.observer;

public class RestaurantNotification
        implements Observer {

    @Override
    public void update(String message) {

        System.out.println(
                "Restaurant Notification : "
                        + message
        );
    }
}