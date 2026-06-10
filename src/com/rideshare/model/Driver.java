package com.rideshare.model;

public class Driver extends User {

    private Vehicle vehicle;
    private Location location;
    private boolean available;

    public Driver(String id,
                  String name,
                  String phone,
                  Vehicle vehicle,
                  Location location) {

        super(id, name, phone);
        this.vehicle = vehicle;
        this.location = location;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Location getLocation() {
        return location;
    }
}