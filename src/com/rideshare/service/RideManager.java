package com.rideshare.service;

import com.rideshare.model.*;
import com.rideshare.strategy.*;

import java.util.*;

public class RideManager {

    private MatchingStrategy matchingStrategy;
    private FareStrategy fareStrategy;

    private List<Driver> drivers = new ArrayList<>();

    public RideManager(
            MatchingStrategy matchingStrategy,
            FareStrategy fareStrategy) {

        this.matchingStrategy = matchingStrategy;
        this.fareStrategy = fareStrategy;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride requestRide(
            Rider rider,
            Location pickup,
            Location drop) {

        Driver driver =
                matchingStrategy.findDriver(
                        pickup,
                        drivers);

        if (driver == null) {
            throw new RuntimeException(
                    "No Driver Available");
        }

        driver.setAvailable(false);

        Ride ride = new Ride(
                UUID.randomUUID().toString(),
                rider,
                driver,
                pickup,
                drop);

        double fare =
                fareStrategy.calculateFare(
                        pickup,
                        drop);

        ride.setFare(fare);

        ride.setStatus(RideStatus.ACCEPTED);

        rider.addRide(ride);

        return ride;
    }

    public void completeRide(Ride ride) {

        ride.setStatus(
                RideStatus.COMPLETED);

       // ride.getDriver().setAvailable(true);
    }
}