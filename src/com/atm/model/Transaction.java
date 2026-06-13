package com.atm.model;

import com.atm.enums.TransactionStatus;
import com.atm.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {

    private String transactionId;

    private TransactionType type;

    private double amount;

    private LocalDateTime time;

    private TransactionStatus status;

    public Transaction(
            String transactionId,
            TransactionType type,
            double amount,
            TransactionStatus status) {

        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.time = LocalDateTime.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }
}
