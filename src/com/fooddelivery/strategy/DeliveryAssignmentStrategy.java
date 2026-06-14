package com.fooddelivery.strategy;

import com.fooddelivery.model.DeliveryPartner;

import java.util.List;

public interface DeliveryAssignmentStrategy {

    DeliveryPartner assignPartner(
            List<DeliveryPartner> partners
    );
}