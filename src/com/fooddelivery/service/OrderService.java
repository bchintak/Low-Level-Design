package com.fooddelivery.service;

import com.fooddelivery.builder.OrderBuilder;
import com.fooddelivery.enums.PaymentType;
import com.fooddelivery.model.*;

import com.fooddelivery.repository.OrderRepository;

import java.util.ArrayList;
import java.util.UUID;

public class OrderService {

    private final PaymentService paymentService;

    private final OrderRepository orderRepository;

    public OrderService(
            PaymentService paymentService,
            OrderRepository orderRepository) {

        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(
            Customer customer,
            Restaurant restaurant,
            Cart cart,
            Address address,
            PaymentType paymentType) {

        if(cart.getItems().isEmpty()) {

            throw new IllegalStateException(
                    "Cart is empty"
            );
        }

        String orderId =
                UUID.randomUUID().toString();

        Order order =
                new OrderBuilder()
                        .orderId(orderId)
                        .customer(customer)
                        .restaurant(restaurant)
                        .items(new ArrayList<>(cart.getItems()))
                        .totalAmount(cart.getTotalAmount())
                        .address(address)
                        .build();

        Payment payment =
                new Payment(
                        UUID.randomUUID().toString(),
                        order.getTotalAmount(),
                        paymentType
                );

        boolean success =
                paymentService.processPayment(
                        payment
                );

        if(!success) {

            throw new RuntimeException(
                    "Payment Failed"
            );
        }

        order.setPayment(payment);

        orderRepository.save(order);

        cart.clear();

        System.out.println(
                "Order Created : "
                        + orderId
        );

        return order;
    }

    public Order trackOrder(
            String orderId) {

        return orderRepository.findById(
                orderId
        );
    }
}