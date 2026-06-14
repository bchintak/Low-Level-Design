package com.wms.state;

import com.wms.model.Order;

public class ShippedState implements OrderState {

    @Override
    public void reserve(Order order) {
        throw new IllegalStateException(
                "Order is already shipped"
        );
    }

    @Override
    public void ship(Order order) {
        throw new IllegalStateException(
                "Order is already shipped"
        );
    }

    @Override
    public void cancel(Order order) {
        throw new IllegalStateException(
                "Cannot cancel a shipped order"
        );
    }
}