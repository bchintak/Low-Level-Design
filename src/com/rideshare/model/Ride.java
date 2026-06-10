package com.rideshare.model;

import com.rideshare.model.Driver;

public class Ride {

    private String rideId;
    private Rider rider;
    private Driver driver;

    private Location pickup;
    private Location drop;

    private double fare;

    private RideStatus status;

    public Ride(String rideId,
                Rider rider,
                Driver driver,
                Location pickup,
                Location drop) {

        this.rideId = rideId;
        this.rider = rider;
        this.driver = driver;
        this.pickup = pickup;
        this.drop = drop;
        this.status = RideStatus.REQUESTED;
    }


    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

}