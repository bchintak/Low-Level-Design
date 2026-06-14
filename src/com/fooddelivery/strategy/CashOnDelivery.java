package com.fooddelivery.strategy;

public class CashOnDelivery
        implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Cash On Delivery Selected"
        );

        return true;
    }
}