package com.atm.service;

import com.atm.model.Account;
import com.atm.model.Transaction;

public class TransactionHistoryService {
    public void addTransaction(Account account, Transaction transaction) {
        account.getTransactionHistory().add(transaction);
    }
}
