package com.vendingmachine;

import com.vendingmachine.inventory.Inventory;
import com.vendingmachine.machine.VendingMachine;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.model.Product;
import com.vendingmachine.payment.CoinPayment;
import com.vendingmachine.payment.UpiPayment;

public class Main {
    public static void main(String[] args) {

        Inventory inventory =
                new Inventory();

        Product coke =
                new Product(
                        "P1",
                        "Coke",
                        20
                );

        inventory.addShelf(
                new ItemShelf(
                        101,
                        coke,
                        5
                )
        );

        VendingMachine machine =
                new VendingMachine(
                        inventory
                );

        machine.makePayment(
                new CoinPayment(10)
        );

        machine.makePayment(
                new UpiPayment(20)
        );

        machine.selectProduct(101);

        machine.dispenseProduct();

        machine.returnChange();
    }
}