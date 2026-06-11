package com.splitwise.strategy;

import com.splitwise.model.Split;
import com.splitwise.model.User;

import java.util.List;

public interface SplitStrategy {

    List<Split> calculate(
            double amount,
            List<User> users,
            List<Double> values
    );
}