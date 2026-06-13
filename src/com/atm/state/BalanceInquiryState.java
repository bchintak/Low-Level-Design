package com.atm.state;

import com.atm.model.ATM;
import com.atm.service.BankService;

public class BalanceInquiryState
        implements ATMState {

    private final BankService bankService =
            new BankService();

    @Override
    public void displayBalance(
            ATM atm) {

        double balance =
                bankService.getBalance(
                        atm.getCurrentCard()
                                .getAccount()
                );

        System.out.println(
                "Current Balance : "
                        + balance
        );

        atm.setState(
                new TransactionCompleteState()
        );
    }
}