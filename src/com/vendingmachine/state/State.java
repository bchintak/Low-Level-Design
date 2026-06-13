package com.vendingmachine.state;

import com.vendingmachine.payment.PaymentStrategy;

public interface State {

    void makePayment(PaymentStrategy paymentStrategy);

    void selectProduct(int shelfCode);

    void dispenseProduct();

    void returnChange();

    void cancelTransaction();
}