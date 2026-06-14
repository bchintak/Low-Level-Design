package com.fooddelivery.model;

import com.fooddelivery.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {

    private String paymentId;

    private double amount;

    private PaymentType paymentType;

    private boolean successful;

    public Payment(String paymentId,
                   double amount,
                   PaymentType paymentType) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentType = paymentType;
    }

}