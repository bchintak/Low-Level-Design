package com.bookmyshow.service;

import com.bookmyshow.factory.PaymentGatewayFactory;
import com.bookmyshow.payment.PaymentGateway;

public class PaymentService {

    public boolean pay(
            double amount) {

        PaymentGateway gateway =
                PaymentGatewayFactory
                        .getGateway("RAZORPAY");

        boolean success =
                gateway.pay(amount);

        if(success) {

            System.out.println(
                    "Payment Successful : "
                            + amount
            );
        }

        return success;
    }
}