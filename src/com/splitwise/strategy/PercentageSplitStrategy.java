package com.splitwise.strategy;

import com.splitwise.model.Split;
import com.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy
        implements SplitStrategy {

    @Override
    public List<Split> calculate(
            double amount,
            List<User> users,
            List<Double> values) {

        List<Split> splits = new ArrayList<>();

        for(int i=0;i<users.size();i++) {

            double share =
                    amount * values.get(i) / 100;

            splits.add(
                    new Split(
                            users.get(i),
                            share
                    )
            );
        }

        return splits;
    }
}