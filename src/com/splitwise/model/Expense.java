package com.splitwise.model;

import java.util.List;

public class Expense {

    private String id;
    private double amount;

    private User paidBy;

    private List<Split> splits;

    public Expense(String id,
                   double amount,
                   User paidBy,
                   List<Split> splits) {

        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }
}