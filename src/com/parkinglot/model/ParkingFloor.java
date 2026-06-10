package com.parkinglot.model;

import java.util.List;

public class ParkingFloor {

    private final int floorNumber;
    private final List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber,
                        List<ParkingSlot> slots) {

        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
