package com.shipment_tracking_system.model;

public class Location {

    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Location(String city,
                    String state,
                    String country,
                    String zipCode) {

        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String toString() {
        return city + ", " + state + ", " + country;
    }
}