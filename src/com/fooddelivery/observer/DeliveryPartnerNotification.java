package com.fooddelivery.observer;

public class DeliveryPartnerNotification
        implements Observer {

    @Override
    public void update(
            String message) {

        System.out.println(
                "[Delivery Partner] "
                        + message
        );
    }
}