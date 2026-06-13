package com.vendingmachine.payment;

public class CardPayment implements PaymentStrategy {

    private final int amount;

    public CardPayment(int amount) {
        this.amount = amount;
    }

    @Override
    public int pay() {

        System.out.println(
                "Card Payment Successful : " + amount
        );

        return amount;
    }
}