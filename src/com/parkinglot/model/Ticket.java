package com.parkinglot.model;

import java.time.LocalDateTime;

public class Ticket {

    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSlot slot;
    private final LocalDateTime entryTime;

    public Ticket(String ticketId,
                  Vehicle vehicle,
                  ParkingSlot slot) {

        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = LocalDateTime.now();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
