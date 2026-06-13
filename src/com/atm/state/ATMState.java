package com.atm.state;

import com.atm.enums.TransactionType;
import com.atm.model.ATM;
import com.atm.model.Card;

public interface ATMState {

    default void insertCard(
            ATM atm,
            Card card) {
        throw new UnsupportedOperationException();
    }

    default void authenticatePin(
            ATM atm,
            int pin) {
        throw new UnsupportedOperationException();
    }

    default void selectOperation(
            ATM atm,
            TransactionType transactionType) {
        throw new UnsupportedOperationException();
    }

    default void withdrawCash(
            ATM atm,
            double amount) {
        throw new UnsupportedOperationException();
    }

    default void displayBalance(
            ATM atm) {
        throw new UnsupportedOperationException();
    }

    default void ejectCard(
            ATM atm) {
        throw new UnsupportedOperationException();
    }

    default void changePin(
            ATM atm,
            int newPin) {
        throw new UnsupportedOperationException();
    }

    default void depositCash(
            ATM atm,
            double amount) {
        throw new UnsupportedOperationException();
    }



}