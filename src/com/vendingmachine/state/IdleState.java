package com.vendingmachine.state;

import com.vendingmachine.machine.VendingMachine;
import com.vendingmachine.payment.PaymentStrategy;

public class IdleState implements State {

    private final VendingMachine machine;

    public IdleState(
            VendingMachine machine) {

        this.machine = machine;
    }

    @Override
    public void makePayment(
            PaymentStrategy paymentStrategy) {

        int amount =
                paymentStrategy.pay();

        machine.addMoney(amount);

        machine.setCurrentState(
                new ReadyState(machine)
        );
    }

    @Override
    public void selectProduct(int shelfCode) {
        throw new RuntimeException(
                "Make payment first"
        );
    }

    @Override
    public void dispenseProduct() {
        throw new RuntimeException();
    }

    @Override
    public void returnChange() {
        throw new RuntimeException();
    }

    @Override
    public void cancelTransaction() {
        System.out.println(
                "Nothing to cancel"
        );
    }
}