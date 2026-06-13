package com.atm;

import com.atm.enums.TransactionType;
import com.atm.model.*;
import com.atm.state.*;

public class Main {

    public static void main(String[] args) {

        // -----------------------------
        // Create Cash Inventory
        // -----------------------------

        CashInventory inventory =
                new CashInventory();

        inventory.addNotes(500, 20);
        inventory.addNotes(200, 20);
        inventory.addNotes(100, 20);

        // -----------------------------
        // Create Account
        // -----------------------------

        Account account =
                new Account(
                        "ACC001",
                        10000
                );

        // -----------------------------
        // Create Card
        // -----------------------------

        Card card =
                new Card(
                        "CARD001",
                        1234,
                        account
                );

        // -----------------------------
        // Create ATM
        // -----------------------------

        ATM atm =
                new ATM(inventory);

        // -----------------------------
        // Insert Card
        // -----------------------------

        atm.getCurrentState()
                .insertCard(
                        atm,
                        card
                );

        // -----------------------------
        // Enter PIN
        // -----------------------------

        atm.getCurrentState()
                .authenticatePin(
                        atm,
                        1234
                );

        // -----------------------------
        // Select Withdrawal
        // -----------------------------

        atm.getCurrentState()
                .selectOperation(
                        atm,
                        TransactionType.CASH_WITHDRAWAL
                );

        // -----------------------------
        // Withdraw Amount
        // -----------------------------

        atm.getCurrentState()
                .withdrawCash(
                        atm,
                        1300
                );

        // -----------------------------
        // Eject Card
        // -----------------------------

        atm.getCurrentState()
                .ejectCard(atm);

        System.out.println(
                "\nRemaining Balance : "
                        + account.getBalance()
        );
    }
}