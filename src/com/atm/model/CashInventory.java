package com.atm.model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CashInventory {

    private final Map<Integer,Integer> notes =
            new TreeMap<>(Collections.reverseOrder());

    public void addNotes(
            int denomination,
            int count) {

        notes.put(
                denomination,
                notes.getOrDefault(
                        denomination,
                        0
                ) + count
        );
    }

    public int getCount(
            int denomination) {

        return notes.getOrDefault(
                denomination,
                0
        );
    }

    public void removeNotes(
            int denomination,
            int count) {

        notes.put(
                denomination,
                notes.get(denomination) - count
        );
    }

    public Map<Integer,Integer> getNotes() {
        return notes;
    }
}
