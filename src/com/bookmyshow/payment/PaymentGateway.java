package com.bookmyshow.payment;

public interface PaymentGateway {
    boolean pay(double amount);
}
