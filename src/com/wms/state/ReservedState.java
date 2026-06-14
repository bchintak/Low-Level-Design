package com.wms.state;

import com.wms.model.Order;

public class ReservedState
        implements OrderState {

    @Override
    public void reserve(Order order) {
        throw new RuntimeException();
    }

    @Override
    public void ship(Order order) {

        System.out.println(
                "Order Shipped");

        order.setCurrentState(
                new ShippedState());
    }

    @Override
    public void cancel(Order order) {

        order.setCurrentState(
                new CancelledState());
    }
}