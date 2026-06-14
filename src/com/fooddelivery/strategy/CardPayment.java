package com.fooddelivery.strategy;

public class CardPayment
        implements PaymentStrategy {

    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Processing Card Payment : "
                        + amount
        );

        return true;
    }
}