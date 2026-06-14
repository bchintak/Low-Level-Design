package com.fooddelivery.state;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.model.Order;

public class ReadyForPickupState implements OrderState {

    @Override
    public void prepare(Order order) {

        throw new IllegalStateException(
                "Order already prepared"
        );
    }

    @Override
    public void readyForPickup(Order order) {

        throw new IllegalStateException(
                "Order already ready for pickup"
        );
    }

    @Override
    public void pickup(Order order) {

        order.setStatus(
                OrderStatus.PICKED_UP
        );

        order.setCurrentState(
                new PickedUpState()
        );

        System.out.println(
                "Order picked up by delivery partner"
        );
    }

    @Override
    public void deliver(Order order) {

        throw new IllegalStateException(
                "Order not picked up yet"
        );
    }

    @Override
    public void cancel(Order order) {

        throw new IllegalStateException(
                "Cannot cancel after food is ready"
        );
    }
}