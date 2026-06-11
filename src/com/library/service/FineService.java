package com.library.service;

import com.library.strategy.*;

public class FineService {

    private FineCalculationStrategy strategy;

    public FineService(FineCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFine(long overdueDays) {
        return strategy.calculate(overdueDays);
    }
}