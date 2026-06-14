package com.wms.model;

import com.wms.state.CreatedState;
import com.wms.state.OrderState;

import java.util.List;

public class Order {

    private String orderId;

    private List<OrderItem> items;

    private OrderState currentState;

    public Order(String orderId,
                 List<OrderItem> items) {

        this.orderId = orderId;
        this.items = items;
        this.currentState =
                new CreatedState();
    }

    public void reserve() {
        currentState.reserve(this);
    }

    public void ship() {
        currentState.ship(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    public void setCurrentState(
            OrderState state) {
        this.currentState = state;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}