package com.library.strategy;

public class DailyFineStrategy
        implements FineCalculationStrategy {

    @Override
    public double calculate(long overdueDays) {

        return overdueDays * 5;
    }
}