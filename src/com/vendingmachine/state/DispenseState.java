package com.vendingmachine.state;

import com.vendingmachine.machine.VendingMachine;
import com.vendingmachine.payment.PaymentStrategy;

public class DispenseState implements State {

    private final VendingMachine machine;

    public DispenseState(
            VendingMachine machine) {

        this.machine = machine;
    }

    @Override
    public void makePayment(
            PaymentStrategy paymentStrategy) {

        throw new RuntimeException(
                "Already Processing"
        );
    }

    @Override
    public void selectProduct(
            int shelfCode) {

        throw new RuntimeException();
    }

    @Override
    public void dispenseProduct() {

        machine.dispenseItem();

        machine.setCurrentState(
                new ReturnChangeState(machine)
        );
    }

    @Override
    public void returnChange() {
        throw new RuntimeException();
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException();
    }
}