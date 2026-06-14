package com.fooddelivery.state;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.model.Order;

public class PlacedState implements OrderState {

    @Override
    public void prepare(Order order) {

        order.setStatus(
                OrderStatus.PREPARING
        );

        order.setCurrentState(
                new PreparingState()
        );

        System.out.println(
                "Order moved to PREPARING"
        );
    }

    @Override
    public void readyForPickup(Order order) {
        throw new IllegalStateException(
                "Cannot move directly to READY_FOR_PICKUP"
        );
    }

    @Override
    public void pickup(Order order) {
        throw new IllegalStateException(
                "Food not prepared yet"
        );
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException(
                "Food not picked up"
        );
    }

    @Override
    public void cancel(Order order) {

        order.setStatus(
                OrderStatus.CANCELLED
        );

        order.setCurrentState(
                new CancelledState()
        );

        System.out.println(
                "Order Cancelled"
        );
    }
}