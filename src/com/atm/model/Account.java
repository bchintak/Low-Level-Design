package com.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String accountNumber;
    private double balance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(String accountNumber,
                   double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount) {
        balance -= amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
    public void credit(
            double amount){

        balance += amount;
    }
}