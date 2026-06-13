package com.atm.state;

import com.atm.model.ATM;
import com.atm.model.Account;

public class CashDepositState
        implements ATMState {

    @Override
    public void depositCash(
            ATM atm,
            double amount) {

        Account account =
                atm.getCurrentCard()
                        .getAccount();

        account.credit(amount);

        // we can update the denominations in the ATM as well?


        System.out.println(
                "Amount Deposited : "
                        + amount
        );

        atm.setState(
                new TransactionCompleteState()
        );
    }
}
