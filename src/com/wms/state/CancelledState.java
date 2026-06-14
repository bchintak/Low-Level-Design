package com.wms.state;

import com.wms.model.Order;

public class CancelledState implements OrderState {

    @Override
    public void reserve(Order order) {
        throw new IllegalStateException(
                "Cancelled order cannot be reserved"
        );
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException(
                "Cancelled order cannot be shipped"
        );
    }

    @Override
    public void cancel(Order order) {
        throw new IllegalStateException(
                "Order is already cancelled"
        );
    }
}