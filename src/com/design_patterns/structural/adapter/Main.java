package com.design_patterns.structural.adapter;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor =
                new PaymentAdapter(
                        new StripeGateway());

        processor.processPayment(
                500);
    }
}
