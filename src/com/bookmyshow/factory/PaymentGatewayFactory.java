package com.bookmyshow.factory;

import com.bookmyshow.payment.PaymentGateway;
import com.bookmyshow.payment.RazorPayGateway;

public class PaymentGatewayFactory {

    public static PaymentGateway getGateway(
            String type) {

        return switch (type) {
            case "RAZORPAY" -> new RazorPayGateway();
            default -> throw new RuntimeException();
        };
    }
}
