package com.vendingmachine.payment;

public class CoinPayment implements PaymentStrategy {

    private final int amount;

    public CoinPayment(int amount) {
        this.amount = amount;
    }

    @Override
    public int pay() {

        System.out.println(
                "Coin Payment Received : " + amount
        );

        return amount;
    }
}