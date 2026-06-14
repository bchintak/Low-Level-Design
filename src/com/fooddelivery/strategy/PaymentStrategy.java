package com.fooddelivery.strategy;

public interface PaymentStrategy {
    boolean pay(double amount);
}