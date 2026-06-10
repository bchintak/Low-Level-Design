package com.parkinglot.strategy;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingSlot;
import com.parkinglot.model.Vehicle;

import java.util.List;

public interface SlotAllocationStrategy {

    ParkingSlot allocateSlot(
            List<ParkingFloor> floors,
            Vehicle vehicle);
}