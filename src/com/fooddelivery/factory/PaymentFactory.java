package com.fooddelivery.factory;

import com.fooddelivery.enums.PaymentType;
import com.fooddelivery.strategy.*;

public class PaymentFactory {

    private PaymentFactory() {
    }

    public static PaymentStrategy getStrategy(
            PaymentType paymentType) {

        switch (paymentType) {

            case UPI:
                return new UpiPayment();

            case CARD:
                return new CardPayment();

            case COD:
                return new CashOnDelivery();

            default:
                throw new IllegalArgumentException(
                        "Unsupported Payment Type"
                );
        }
    }
}