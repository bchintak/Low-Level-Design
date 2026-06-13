package com.vendingmachine.inventory;

import com.vendingmachine.exception.InvalidSelectionException;
import com.vendingmachine.model.ItemShelf;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Integer, ItemShelf> shelves;

    public Inventory() {

        this.shelves =
                new HashMap<>();
    }

    public void addShelf(ItemShelf shelf) {

        shelves.put(
                shelf.getShelfCode(),
                shelf
        );
    }

    public ItemShelf getShelf(int shelfCode) {

        ItemShelf shelf =
                shelves.get(shelfCode);

        if(shelf == null) {

            throw new InvalidSelectionException(
                    "Invalid Shelf Code : "
                            + shelfCode
            );
        }

        return shelf;
    }

    public void displayProducts() {

        System.out.println(
                "\n===== AVAILABLE PRODUCTS ====="
        );

        for(ItemShelf shelf : shelves.values()) {

            System.out.println(
                    "Shelf : "
                            + shelf.getShelfCode()
                            + " | Product : "
                            + shelf.getProduct().getName()
                            + " | Price : "
                            + shelf.getProduct().getPrice()
                            + " | Quantity : "
                            + shelf.getQuantity()
            );
        }

        System.out.println(
                "===============================\n"
        );
    }

    public Map<Integer, ItemShelf> getShelves() {
        return shelves;
    }
}