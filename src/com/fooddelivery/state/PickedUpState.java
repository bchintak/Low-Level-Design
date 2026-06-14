package com.fooddelivery.state;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.model.Order;

public class PickedUpState implements OrderState {

    @Override
    public void prepare(Order order) {

        throw new IllegalStateException(
                "Order already picked up"
        );
    }

    @Override
    public void readyForPickup(Order order) {

        throw new IllegalStateException(
                "Order already picked up"
        );
    }

    @Override
    public void pickup(Order order) {

        throw new IllegalStateException(
                "Order already picked up"
        );
    }

    @Override
    public void deliver(Order order) {

        order.setStatus(
                OrderStatus.DELIVERED
        );

        order.setCurrentState(
                new DeliveredState()
        );

        order.notifyObservers(
                "Order Delivered Successfully"
        );
    }

    @Override
    public void cancel(Order order) {

        throw new IllegalStateException(
                "Cannot cancel after pickup"
        );
    }
}