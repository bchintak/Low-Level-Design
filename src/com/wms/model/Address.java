package com.wms.model;

public class Address {

    private String city;
    private String state;
    private String pincode;

    public Address(String city,
                   String state,
                   String pincode) {
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }
}