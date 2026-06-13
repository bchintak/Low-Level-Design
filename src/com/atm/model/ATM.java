package com.atm.model;

import com.atm.state.ATMState;
import com.atm.state.IdleState;

public class ATM {

    private ATMState currentState;
    private Card currentCard;
    private CashInventory inventory;

    public ATM(CashInventory inventory){
        this.inventory = inventory;
        this.currentState =
                new IdleState();
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public CashInventory getInventory() {
        return inventory;
    }


}