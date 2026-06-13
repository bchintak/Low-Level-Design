package com.vendingmachine.machine;

import com.vendingmachine.inventory.Inventory;
import com.vendingmachine.model.ItemShelf;
import com.vendingmachine.payment.PaymentStrategy;
import com.vendingmachine.state.IdleState;
import com.vendingmachine.state.State;

public class VendingMachine {

    private final Inventory inventory;

    private State currentState;

    private int insertedAmount;

    private ItemShelf selectedShelf;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.currentState = new IdleState(this);
    }

    // ==========================
    // Delegation
    // ==========================

    public void makePayment(
            PaymentStrategy paymentStrategy) {

        currentState.makePayment(
                paymentStrategy
        );
    }

    public void selectProduct(
            int shelfCode) {

        currentState.selectProduct(
                shelfCode
        );
    }

    public void dispenseProduct() {

        currentState.dispenseProduct();
    }

    public void returnChange() {

        currentState.returnChange();
    }

    public void cancelTransaction() {

        currentState.cancelTransaction();
    }

    // ==========================
    // Business Methods
    // ==========================

    public void addMoney(int amount) {

        insertedAmount += amount;
    }

    public void dispenseItem() {

        selectedShelf.reduceQuantity();

        System.out.println(
                "Dispensed Product : "
                        + selectedShelf
                        .getProduct()
                        .getName()
        );
    }

    public int calculateChange() {

        return insertedAmount
                -
                selectedShelf
                        .getProduct()
                        .getPrice();
    }

    public void reset() {

        insertedAmount = 0;
        selectedShelf = null;
    }

    // ==========================
    // Getters / Setters
    // ==========================

    public Inventory getInventory() {
        return inventory;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(
            State currentState) {

        this.currentState =
                currentState;
    }

    public int getInsertedAmount() {
        return insertedAmount;
    }

    public ItemShelf getSelectedShelf() {
        return selectedShelf;
    }

    public void setSelectedShelf(
            ItemShelf selectedShelf) {

        this.selectedShelf =
                selectedShelf;
    }
}