package com.parkinglot.model;

public class ParkingSlot {

    private final int slotNumber;
    private final VehicleType slotType;

    private Vehicle parkedVehicle;

    public ParkingSlot(int slotNumber,
                       VehicleType slotType) {

        this.slotNumber = slotNumber;
        this.slotType = slotType;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getSlotType() {
        return slotType;
    }
}
