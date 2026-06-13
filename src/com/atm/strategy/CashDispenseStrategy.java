package com.atm.strategy;

import com.atm.model.CashInventory;

import java.util.Map;

public interface CashDispenseStrategy {

    Map<Integer,Integer> dispense(
            CashInventory inventory,
            int amount
    );
}
