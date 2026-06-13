package com.atm.state;

import com.atm.model.ATM;

public class PinChangeState
        implements ATMState {

    @Override
    public void changePin(
            ATM atm,
            int newPin) {

        atm.getCurrentCard()
                .setPin(newPin);

        System.out.println(
                "PIN Updated"
        );

        atm.setState(
                new TransactionCompleteState()
        );
    }
}
