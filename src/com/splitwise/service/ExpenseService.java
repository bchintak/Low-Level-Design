package com.splitwise.service;

import com.splitwise.model.*;

import java.util.List;

public class ExpenseService {

    private BalanceService balanceService;

    public ExpenseService(
            BalanceService balanceService) {

        this.balanceService = balanceService;
    }

    public void addExpense(
            Expense expense) {

        User paidBy = expense.getPaidBy();

        for(Split split :
                expense.getSplits()) {

            if(split.getUser()
                    .getId()
                    .equals(
                            paidBy.getId()))
                continue;

            balanceService.updateBalance(
                    paidBy.getName(),
                    split.getUser().getName(),
                    split.getAmount()
            );
        }
    }
}