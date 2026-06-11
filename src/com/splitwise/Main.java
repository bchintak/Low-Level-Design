package com.splitwise;

import com.splitwise.enums.SplitType;
import com.splitwise.factory.SplitStrategyFactory;
import com.splitwise.model.Expense;
import com.splitwise.model.Group;
import com.splitwise.model.Split;
import com.splitwise.model.User;
import com.splitwise.service.BalanceService;
import com.splitwise.service.ExpenseService;
import com.splitwise.strategy.SplitStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        // ==============================
        // Create Users
        // ==============================

        User bhanu = new User("U1", "Bhanu");
        User ravi = new User("U2", "Ravi");
        User krishna = new User("U3", "Krishna");

        // ==============================
        // Create Group
        // ==============================

        Group tripGroup =
                new Group("G1", "Goa Trip");

        tripGroup.addMember(bhanu);
        tripGroup.addMember(ravi);
        tripGroup.addMember(krishna);

        // ==============================
        // Create Services
        // ==============================

        BalanceService balanceService =
                new BalanceService();

        ExpenseService expenseService =
                new ExpenseService(balanceService);

        // ==============================
        // Expense 1
        // Dinner = 300
        // Paid by Bhanu
        // Equal Split
        // ==============================

        double amount = 300.0;

        List<User> users =
                Arrays.asList(
                        bhanu,
                        ravi,
                        krishna
                );

        SplitStrategy equalStrategy =
                SplitStrategyFactory.getStrategy(
                        SplitType.EQUAL
                );

        List<Split> splits =
                equalStrategy.calculate(
                        amount,
                        users,
                        null
                );

        for (Split split : splits) {
            System.out.println(split.getUser().getName() + " after split "+ split.getAmount());
        }

        Expense dinnerExpense =
                new Expense(
                        UUID.randomUUID().toString(),
                        amount,
                        bhanu,
                        splits
                );

        expenseService.addExpense(
                dinnerExpense
        );

        System.out.println(
                "\nAfter Dinner Expense:"
        );

        balanceService.showBalances();

        // ==============================
        // Expense 2
        // Hotel = 1500
        // Paid by Ravi
        // Exact Split
        // Bhanu=500
        // Ravi=500
        // Krishna=500
        // ==============================

        SplitStrategy exactStrategy =
                SplitStrategyFactory.getStrategy(
                        SplitType.EXACT
                );

        List<Double> exactAmounts =
                Arrays.asList(
                        500.0,
                        500.0,
                        500.0
                );

        List<Split> hotelSplits =
                exactStrategy.calculate(
                        1500,
                        users,
                        exactAmounts
                );

        Expense hotelExpense =
                new Expense(
                        UUID.randomUUID().toString(),
                        1500,
                        ravi,
                        hotelSplits
                );

        expenseService.addExpense(
                hotelExpense
        );

        System.out.println(
                "\nAfter Hotel Expense:"
        );

        balanceService.showBalances();

        // ==============================
        // Expense 3
        // Fuel = 1000
        // Paid by Krishna
        // Percentage Split
        // Bhanu=50%
        // Ravi=30%
        // Krishna=20%
        // ==============================

        SplitStrategy percentageStrategy =
                SplitStrategyFactory.getStrategy(
                        SplitType.PERCENTAGE
                );

        List<Double> percentages =
                Arrays.asList(
                        50.0,
                        30.0,
                        20.0
                );

        List<Split> fuelSplits =
                percentageStrategy.calculate(
                        1000,
                        users,
                        percentages
                );

        Expense fuelExpense =
                new Expense(
                        UUID.randomUUID().toString(),
                        1000,
                        krishna,
                        fuelSplits
                );

        expenseService.addExpense(
                fuelExpense
        );

        System.out.println(
                "\nAfter Fuel Expense:"
        );

        balanceService.showBalances();
    }
}