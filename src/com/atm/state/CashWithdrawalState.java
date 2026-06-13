package com.atm.state;

import com.atm.model.ATM;
import com.atm.model.Account;
import com.atm.service.BankService;
import com.atm.strategy.CashDispenseStrategy;
import com.atm.strategy.LeastNotesStrategy;

import java.util.Map;

public class CashWithdrawalState
        implements ATMState {

    private final BankService bankService =
            new BankService();

    private final CashDispenseStrategy strategy =
            new LeastNotesStrategy();

    @Override
    public void withdrawCash(
            ATM atm,
            double amount) {

        Account account =
                atm.getCurrentCard()
                        .getAccount();

        if(account.getBalance() < amount){

            System.out.println(
                    "Insufficient Balance"
            );

            return;
        }

        Map<Integer,Integer> notes =

                strategy.dispense(
                        atm.getInventory(),
                        (int)amount
                );

        bankService.withdraw(
                account,
                amount
        );

        for(Map.Entry<Integer,Integer> entry
                : notes.entrySet()) {

            atm.getInventory()
                    .removeNotes(
                            entry.getKey(),
                            entry.getValue()
                    );
        }

        System.out.println(
                "Dispensing Cash:"
        );

        notes.forEach(
                (denomination,count) ->
                        System.out.println(
                                denomination
                                        + " -> "
                                        + count
                        )
        );

        atm.setState(
                new TransactionCompleteState()
        );
    }
}