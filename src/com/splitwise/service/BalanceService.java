package com.splitwise.service;

import java.util.HashMap;
import java.util.Map;

public class BalanceService {

    private final Map<String,
            Map<String, Double>>
            balances = new HashMap<>();


    public void updateBalance(
            String lender,
            String borrower,
            double amount) {

        balances
                .computeIfAbsent(lender,
                        k -> new HashMap<>())
                .merge(
                        borrower,
                        amount,
                        Double::sum
                );
    }

    public void showBalances() {

        balances.forEach((lender,map)->{

            map.forEach((borrower,amount)->{

                System.out.println(
                        borrower +
                                " owes " +
                                lender +
                                " : " +
                                amount
                );

            });
        });
    }
}