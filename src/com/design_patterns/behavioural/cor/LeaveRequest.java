package com.design_patterns.behavioural.cor;

public class LeaveRequest {

    private final int numberOfDays;

    public LeaveRequest(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }
}