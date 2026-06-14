package com.fooddelivery.state;

import com.fooddelivery.model.Order;

public interface OrderState {

    void prepare(Order order);

    void readyForPickup(Order order);

    void pickup(Order order);

    void deliver(Order order);

    void cancel(Order order);
}