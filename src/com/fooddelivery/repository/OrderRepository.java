package com.fooddelivery.repository;

import com.fooddelivery.model.Order;

import java.util.*;

public class OrderRepository {

    private final Map<String, Order>
            orders = new HashMap<>();

    public void save(Order order) {

        orders.put(
                order.getOrderId(),
                order
        );
    }

    public Order findById(
            String orderId) {

        return orders.get(orderId);
    }

    public List<Order> findAll() {

        return new ArrayList<>(
                orders.values()
        );
    }
}