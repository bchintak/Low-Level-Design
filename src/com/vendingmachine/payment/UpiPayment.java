package com.vendingmachine.payment;

public class UpiPayment implements PaymentStrategy {

    private final int amount;

    public UpiPayment(int amount) {
        this.amount = amount;
    }

    @Override
    public int pay() {

        System.out.println(
                "UPI Payment Successful : " + amount
        );

        return amount;
    }
}