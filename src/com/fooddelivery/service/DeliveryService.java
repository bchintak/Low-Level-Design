package com.fooddelivery.service;

import com.fooddelivery.model.DeliveryPartner;
import com.fooddelivery.model.Order;

import com.fooddelivery.repository.
        DeliveryPartnerRepository;

import com.fooddelivery.strategy.
        DeliveryAssignmentStrategy;

public class DeliveryService {

    private final DeliveryPartnerRepository repository;

    private final DeliveryAssignmentStrategy strategy;

    public DeliveryService(
            DeliveryPartnerRepository repository,
            DeliveryAssignmentStrategy strategy) {

        this.repository = repository;
        this.strategy = strategy;
    }

    public void assignPartner(
            Order order) {

        DeliveryPartner partner =
                strategy.assignPartner(
                        repository.getPartners()
                );

        partner.setAvailable(false);

        order.setDeliveryPartner(
                partner
        );

        System.out.println(
                "Assigned Partner : "
                        + partner.getName()
        );
    }
}