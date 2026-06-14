package com.fooddelivery.strategy;

public class UpiPayment
        implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Processing UPI Payment : "
                        + amount
        );

        return true;
    }
}