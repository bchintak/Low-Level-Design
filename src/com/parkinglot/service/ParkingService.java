package com.parkinglot.service;

import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSlot;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.strategy.FeeStrategy;
import com.parkinglot.strategy.FeeStrategyFactory;
import com.parkinglot.strategy.SlotAllocationStrategy;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingService {

    private final ParkingLot parkingLot;
    private final SlotAllocationStrategy strategy;

    public ParkingService(
            ParkingLot parkingLot,
            SlotAllocationStrategy strategy) {

        this.parkingLot = parkingLot;
        this.strategy = strategy;
    }

    public Ticket parkVehicle(
            Vehicle vehicle) {

        ParkingSlot slot =
                strategy.allocateSlot(
                        parkingLot.getFloors(),
                        vehicle);

        if (slot == null) {
            throw new RuntimeException(
                    "Parking Full");
        }

        slot.parkVehicle(vehicle);

        return new Ticket(
                UUID.randomUUID().toString(),
                vehicle,
                slot);
    }

    public double exitVehicle(
            Ticket ticket) {

        FeeStrategy feeStrategy =
                FeeStrategyFactory.getStrategy(
                        ticket.getVehicle()
                                .getVehicleType());

        double fee =
                feeStrategy.calculateFee(
                        ticket,
                        LocalDateTime.now());

        ticket.getSlot().removeVehicle();

        return fee;
    }
}