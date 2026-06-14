package com.fooddelivery.model;

import com.fooddelivery.enums.OrderStatus;
import com.fooddelivery.observer.Observer;
import com.fooddelivery.observer.Subject;
import com.fooddelivery.state.OrderState;
import com.fooddelivery.state.PlacedState;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order implements Subject {

    private String orderId;

    private Customer customer;

    private Restaurant restaurant;

    private List<OrderItem> items;

    private double totalAmount;

    private OrderStatus status;

    private OrderState currentState;

    private DeliveryPartner deliveryPartner;

    private Address deliveryAddress;

    private LocalDateTime orderTime;

    private Payment payment;

    // Observer Pattern

    private final List<Observer> observers =
            new ArrayList<>();

    public Order(String orderId,
                 Customer customer,
                 Restaurant restaurant,
                 List<OrderItem> items,
                 double totalAmount,
                 Address deliveryAddress) {

        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;

        this.status = OrderStatus.PLACED;

        this.currentState = new PlacedState();

        this.orderTime = LocalDateTime.now();
    }



    @Override
    public void addObserver(
            Observer observer) {

        observers.add(observer);
    }

    @Override
    public void removeObserver(
            Observer observer) {

        observers.remove(observer);
    }

    @Override
    public void notifyObservers(
            String message) {

        observers.forEach(
                observer ->
                        observer.update(message)
        );
    }

    public void prepare() {
        currentState.prepare(this);
    }

    public void readyForPickup() {
        currentState.readyForPickup(this);
    }

    public void pickup() {
        currentState.pickup(this);
    }

    public void deliver() {
        currentState.deliver(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }
}