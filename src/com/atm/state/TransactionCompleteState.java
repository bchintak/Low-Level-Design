package com.atm.state;

import com.atm.model.ATM;

public class TransactionCompleteState
        implements ATMState {

    @Override
    public void ejectCard(
            ATM atm) {

        System.out.println(
                "Transaction Completed"
        );

        System.out.println(
                "Card Ejected"
        );

        atm.setCurrentCard(null);

        atm.setState(
                new IdleState()
        );
    }
}