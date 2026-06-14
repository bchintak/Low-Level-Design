package com.fooddelivery.strategy;

import com.fooddelivery.model.DeliveryPartner;

import java.util.List;

public class NearestPartnerStrategy
        implements DeliveryAssignmentStrategy {

    @Override
    public DeliveryPartner assignPartner(
            List<DeliveryPartner> partners) {

        return partners.stream()
                .filter(
                        DeliveryPartner::isAvailable
                )
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException(
                                "No delivery partner available"
                        )
                );
    }
}