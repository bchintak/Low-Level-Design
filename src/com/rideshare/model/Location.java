package com.rideshare.model;

public class Location {

    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double distance(Location other) {

        double dx = latitude - other.latitude;
        double dy = longitude - other.longitude;

        return Math.sqrt(dx * dx + dy * dy);
    }
}