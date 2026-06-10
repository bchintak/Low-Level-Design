package com.rideshare.strategy;

import com.rideshare.model.Location;

public class DefaultFareStrategy
        implements FareStrategy {

    @Override
    public double calculateFare(
            Location pickup,
            Location drop) {

        double distance = pickup.distance(drop);

        return distance * 15;
    }
}