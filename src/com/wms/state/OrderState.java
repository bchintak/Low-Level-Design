package com.wms.state;

import com.wms.model.Order;

public interface OrderState {

    void reserve(Order order);

    void ship(Order order);

    void cancel(Order order);
}