package com.atm.strategy;

import com.atm.model.CashInventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeastNotesStrategy
        implements CashDispenseStrategy {

    @Override
    public Map<Integer,Integer> dispense(
            CashInventory inventory,
            int amount) {

        Map<Integer,Integer> result =
                new LinkedHashMap<>();

        for(Integer denomination :
                inventory.getNotes().keySet()) {

            int available =
                    inventory.getCount(
                            denomination
                    );

            int required =
                    amount / denomination;

            int used =
                    Math.min(
                            required,
                            available
                    );

            if(used > 0){

                result.put(
                        denomination,
                        used
                );

                amount -=
                        denomination * used;
            }
        }

        if(amount != 0){

            throw new RuntimeException(
                    "Cannot Dispense Amount"
            );
        }

        return result;
    }
}
