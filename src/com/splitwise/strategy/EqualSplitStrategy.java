package com.splitwise.strategy;

import com.splitwise.model.Split;
import com.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy
        implements SplitStrategy {

    @Override
    public List<Split> calculate(
            double amount,
            List<User> users,
            List<Double> values) {

        List<Split> splits = new ArrayList<>();

        double share = amount / users.size();

        for(User user : users) {
            splits.add(new Split(user, share));
        }

        return splits;
    }
}