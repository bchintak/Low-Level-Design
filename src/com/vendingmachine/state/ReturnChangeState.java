package com.vendingmachine.state;

import com.vendingmachine.machine.VendingMachine;
import com.vendingmachine.payment.PaymentStrategy;

public class ReturnChangeState implements State {

    private final VendingMachine machine;

    public ReturnChangeState(
            VendingMachine machine) {

        this.machine = machine;
    }

    @Override
    public void makePayment(
            PaymentStrategy paymentStrategy) {

        throw new RuntimeException();
    }

    @Override
    public void selectProduct(
            int shelfCode) {

        throw new RuntimeException();
    }

    @Override
    public void dispenseProduct() {

        throw new RuntimeException();
    }

    @Override
    public void returnChange() {

        System.out.println(
                "Returned Change : "
                        + machine.calculateChange()
        );

        machine.reset();

        machine.setCurrentState(
                new IdleState(machine)
        );
    }

    @Override
    public void cancelTransaction() {

        throw new RuntimeException();
    }
}