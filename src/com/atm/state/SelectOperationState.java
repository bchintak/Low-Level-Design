package com.atm.state;

import com.atm.enums.TransactionType;
import com.atm.model.ATM;

public class SelectOperationState
        implements ATMState {

    @Override
    public void selectOperation(
            ATM atm,
            TransactionType transactionType) {

        switch (transactionType) {

            case CASH_WITHDRAWAL:

                atm.setState(
                        new CashWithdrawalState()
                );

                break;

            case BALANCE_INQUIRY:

                atm.setState(
                        new BalanceInquiryState()
                );

                break;
        }
    }
}