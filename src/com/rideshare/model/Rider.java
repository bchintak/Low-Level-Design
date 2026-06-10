package com.rideshare.model;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {
    private List<Ride> rides = new ArrayList<>();

    public Rider(String id, String name, String phone) {
        super(id, name, phone);
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }
}
