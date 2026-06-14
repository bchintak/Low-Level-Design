package com.fooddelivery.model;

public class DeliveryPartner extends User {

    private boolean available = true;

    public DeliveryPartner(String id,
                           String name,
                           String phone) {

        super(id,name,phone);
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}