package com.rideshare.strategy;

import com.rideshare.model.Driver;
import com.rideshare.model.Location;

import java.util.List;

public class NearestDriverMatchingStrategy
        implements MatchingStrategy {

    @Override
    public Driver findDriver(
            Location pickup,
            List<Driver> drivers) {

        Driver nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : drivers) {

            if (!driver.isAvailable()) {
                continue;
            }

            double distance =
                    driver.getLocation().distance(pickup);

            if (distance < minDistance) {
                minDistance = distance;
                nearest = driver;
            }
        }

        return nearest;
    }
}