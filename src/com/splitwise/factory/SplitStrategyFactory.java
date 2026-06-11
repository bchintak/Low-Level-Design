package com.splitwise.factory;

import com.splitwise.enums.SplitType;
import com.splitwise.strategy.*;

public class SplitStrategyFactory {

    public static SplitStrategy getStrategy(
            SplitType type) {

        switch (type) {

            case EQUAL:
                return new EqualSplitStrategy();

            case EXACT:
                return new ExactSplitStrategy();

            case PERCENTAGE:
                return new PercentageSplitStrategy();

            default:
                throw new IllegalArgumentException();
        }
    }
}