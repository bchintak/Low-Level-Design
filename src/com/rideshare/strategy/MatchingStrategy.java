package com.rideshare.strategy;

import com.rideshare.model.Driver;
import com.rideshare.model.Location;

import java.util.List;

public interface MatchingStrategy {

    Driver findDriver(
            Location pickup,
            List<Driver> drivers);
}