package com.rideshare;

import com.rideshare.model.*;
import com.rideshare.service.*;
import com.rideshare.strategy.*;

public class Main {

    public static void main(String[] args) {

        RideManager manager =
                new RideManager(
                        new NearestDriverMatchingStrategy(),
                        new DefaultFareStrategy());

        Driver d1 = new Driver(
                "D1",
                "Ravi",
                "999999",
                new Vehicle("V1", "AP39AA1111"),
                new Location(10, 10));

        Driver d2 = new Driver(
                "D2",
                "Kiran",
                "888888",
                new Vehicle("V2", "AP39AA2222"),
                new Location(5, 5));

        manager.registerDriver(d1);
        manager.registerDriver(d2);

        Rider rider =
                new Rider(
                        "R1",
                        "Bhanu",
                        "777777");

        Ride ride =
                manager.requestRide(
                        rider,
                        new Location(4, 4),
                        new Location(20, 20));

        System.out.println("Ride booked");
    }
}