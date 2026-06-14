package com.fooddelivery.state;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.model.Order;

public class PreparingState implements OrderState {

    @Override
    public void prepare(Order order) {
        throw new IllegalStateException(
                "Already preparing"
        );
    }

    @Override
    public void readyForPickup(Order order) {

        order.setStatus(
                OrderStatus.READY_FOR_PICKUP
        );

        order.setCurrentState(
                new ReadyForPickupState()
        );

        order.notifyObservers(
                "Food Ready For Pickup"
        );
    }

    @Override
    public void pickup(Order order) {
        throw new IllegalStateException(
                "Food not ready"
        );
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException(
                "Food not picked"
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