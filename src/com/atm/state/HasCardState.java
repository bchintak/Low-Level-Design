package com.atm.state;

import com.atm.model.ATM;

public class HasCardState implements ATMState {

    @Override
    public void authenticatePin(
            ATM atm,
            int pin) {

        if (atm.getCurrentCard()
                .validatePin(pin)) {

            System.out.println(
                    "PIN Verified"
            );

            atm.setState(
                    new SelectOperationState()
            );

        } else {

            System.out.println(
                    "Invalid PIN"
            );
        }
    }

    @Override
    public void ejectCard(
            ATM atm) {

        atm.setCurrentCard(null);

        atm.setState(
                new IdleState()
        );

        System.out.println(
                "Card Ejected"
        );
    }
}