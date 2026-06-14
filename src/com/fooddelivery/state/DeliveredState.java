package com.fooddelivery.state;

import com.fooddelivery.model.Order;

public class DeliveredState implements OrderState {

    @Override
    public void prepare(Order order) {

        throw new IllegalStateException(
                "Order already delivered"
        );
    }

    @Override
    public void readyForPickup(Order order) {

        throw new IllegalStateException(
                "Order already delivered"
        );
    }

    @Override
    public void pickup(Order order) {

        throw new IllegalStateException(
                "Order already delivered"
        );
    }

    @Override
    public void deliver(Order order) {

        throw new IllegalStateException(
                "Order already delivered"
        );
    }

    @Override
    public void cancel(Order order) {

        throw new IllegalStateException(
                "Delivered order cannot be cancelled"
        );
    }
}