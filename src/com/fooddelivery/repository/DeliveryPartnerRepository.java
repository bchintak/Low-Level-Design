package com.fooddelivery.repository;

import com.fooddelivery.model.DeliveryPartner;

import java.util.*;

public class DeliveryPartnerRepository {

    private final List<DeliveryPartner>
            partners = new ArrayList<>();

    public void addPartner(
            DeliveryPartner partner) {

        partners.add(partner);
    }

    public List<DeliveryPartner> getPartners() {
        return partners;
    }
}