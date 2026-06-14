package com.fooddelivery.state;

import com.fooddelivery.model.Order;

public class CancelledState implements OrderState {

    @Override
    public void prepare(Order order) {

        throw new IllegalStateException(
                "Order is cancelled"
        );
    }

    @Override
    public void readyForPickup(Order order) {

        throw new IllegalStateException(
                "Order is cancelled"
        );
    }

    @Override
    public void pickup(Order order) {

        throw new IllegalStateException(
                "Order is cancelled"
        );
    }

    @Override
    public void deliver(Order order) {

        throw new IllegalStateException(
                "Order is cancelled"
        );
    }

    @Override
    public void cancel(Order order) {

        throw new IllegalStateException(
                "Order already cancelled"
        );
    }
}