package com.atm.state;

import com.atm.model.ATM;
import com.atm.model.Card;

public class IdleState implements ATMState {

    @Override
    public void insertCard(
            ATM atm,
            Card card) {

        atm.setCurrentCard(card);

        atm.setState(
                new HasCardState()
        );

        System.out.println(
                "Card Inserted"
        );
    }
}