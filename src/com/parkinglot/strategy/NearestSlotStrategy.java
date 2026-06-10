package com.parkinglot.strategy;

import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingSlot;
import com.parkinglot.model.Vehicle;

import java.util.List;

public class NearestSlotStrategy
        implements SlotAllocationStrategy {

    @Override
    public ParkingSlot allocateSlot(
            List<ParkingFloor> floors,
            Vehicle vehicle) {

        for (ParkingFloor floor : floors) {

            for (ParkingSlot slot : floor.getSlots()) {

                if (slot.isAvailable()
                        && slot.getSlotType()
                        == vehicle.getVehicleType()) {

                    return slot;
                }
            }
        }

        return null;
    }
}
