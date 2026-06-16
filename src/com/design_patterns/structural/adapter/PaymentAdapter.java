package com.design_patterns.structural.adapter;

public class PaymentAdapter implements PaymentProcessor {
    private StripeGateway gateway;

    public PaymentAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }


    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
