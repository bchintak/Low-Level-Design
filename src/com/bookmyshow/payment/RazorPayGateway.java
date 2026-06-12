package com.bookmyshow.payment;

public class RazorPayGateway
        implements PaymentGateway {

    @Override
    public boolean pay(double amount) {
        return true;
    }
}
