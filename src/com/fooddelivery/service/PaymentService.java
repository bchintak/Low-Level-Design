package com.fooddelivery.service;

import com.fooddelivery.factory.PaymentFactory;
import com.fooddelivery.model.Payment;
import com.fooddelivery.strategy.PaymentStrategy;

public class PaymentService {

    public boolean processPayment(
            Payment payment) {

        PaymentStrategy strategy =
                PaymentFactory.getStrategy(
                        payment.getPaymentType()
                );

        boolean success =
                strategy.pay(
                        payment.getAmount()
                );

        payment.setSuccessful(success);

        return success;
    }
}