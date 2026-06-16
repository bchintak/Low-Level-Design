package com.design_patterns.structural.adapter;

public class StripeGateway {

    public void makePayment(double amount) {

        System.out.println(
                "Stripe payment: " + amount
        );
    }
}
