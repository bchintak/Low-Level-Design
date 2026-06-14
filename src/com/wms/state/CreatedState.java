package com.wms.state;

import com.wms.model.Order;

public class CreatedState
        implements OrderState {

    @Override
    public void reserve(Order order) {

        System.out.println(
                "Inventory Reserved");

        order.setCurrentState(
                new ReservedState());
    }

    @Override
    public void ship(Order order) {
        throw new RuntimeException(
                "Reserve first");
    }

    @Override
    public void cancel(Order order) {

        order.setCurrentState(
                new CancelledState());
    }
}