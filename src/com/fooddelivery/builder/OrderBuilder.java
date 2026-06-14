package com.fooddelivery.builder;

import com.fooddelivery.model.*;

import java.util.List;

public class OrderBuilder {

    private String orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<OrderItem> items;
    private double totalAmount;
    private Address address;

    public OrderBuilder orderId(
            String orderId) {

        this.orderId = orderId;
        return this;
    }

    public OrderBuilder customer(
            Customer customer) {

        this.customer = customer;
        return this;
    }

    public OrderBuilder restaurant(
            Restaurant restaurant) {

        this.restaurant = restaurant;
        return this;
    }

    public OrderBuilder items(
            List<OrderItem> items) {

        this.items = items;
        return this;
    }

    public OrderBuilder totalAmount(
            double totalAmount) {

        this.totalAmount = totalAmount;
        return this;
    }

    public OrderBuilder address(
            Address address) {

        this.address = address;
        return this;
    }

    public Order build() {

        return new Order(
                orderId,
                customer,
                restaurant,
                items,
                totalAmount,
                address
        );
    }
}