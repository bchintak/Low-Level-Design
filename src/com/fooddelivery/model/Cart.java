package com.fooddelivery.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<OrderItem> items =
            new ArrayList<>();

    public void addItem(MenuItem item,
                        int quantity) {

        items.add(
                new OrderItem(
                        item,
                        quantity
                )
        );
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {

        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public void clear() {
        items.clear();
    }
}