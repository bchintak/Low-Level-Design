package com.atm.service;

import com.atm.model.Account;

public class BankService {

    public boolean withdraw(
            Account account,
            double amount) {

        if (account.getBalance() < amount) {
            return false;
        }

        account.debit(amount);

        return true;
    }

    public double getBalance(
            Account account) {

        return account.getBalance();
    }
}