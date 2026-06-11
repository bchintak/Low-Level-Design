package com.shipment_tracking_system.model;

public class Carrier {

    private String carrierId;

    private String name;

    public Carrier(String carrierId, String name) {
        this.carrierId = carrierId;
        this.name = name;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
