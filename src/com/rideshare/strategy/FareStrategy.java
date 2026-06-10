package com.rideshare.strategy;

import com.rideshare.model.Location;

public interface FareStrategy {

    double calculateFare(
            Location pickup,
            Location drop);
}