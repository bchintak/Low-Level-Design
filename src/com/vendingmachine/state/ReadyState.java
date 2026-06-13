package com.vendingmachine.state;

import com.vendingmachine.exception.InsufficientBalanceException;
import com.vendingmachine.exception.OutOfStockException;
import com.vendingmachine.machine.VendingMachine;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.payment.PaymentStrategy;

public class ReadyState implements State {

    private final VendingMachine machine;

    public ReadyState(
            VendingMachine machine) {

        this.machine = machine;
    }

    @Override
    public void makePayment(
            PaymentStrategy paymentStrategy) {

        machine.addMoney(
                paymentStrategy.pay()
        );
    }

    @Override
    public void selectProduct(
            int shelfCode) {

        ItemShelf shelf =
                machine.getInventory()
                        .getShelf(shelfCode);

        if(!shelf.isAvailable()) {

            throw new OutOfStockException(
                    "Out Of Stock"
            );
        }

        if(machine.getInsertedAmount()
                <
                shelf.getProduct()
                        .getPrice()) {

            throw new InsufficientBalanceException(
                    "Insufficient Balance"
            );
        }

        machine.setSelectedShelf(
                shelf
        );

        machine.setCurrentState(
                new DispenseState(machine)
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
                "Returned Amount : "
                        + machine.getInsertedAmount()
        );

        machine.reset();

        machine.setCurrentState(
                new IdleState(machine)
        );
    }
}