package com.shipment_tracking_system.model;

import com.shipment_tracking_system.enums.ShipmentStatus;

import java.time.LocalDateTime;

public class TrackingEvent {

    private LocalDateTime timestamp;

    private ShipmentStatus status;

    private Location location;

    private String remarks;

    public TrackingEvent(LocalDateTime timestamp, ShipmentStatus status, Location location, String remarks) {
        this.timestamp = timestamp;
        this.status = status;
        this.location = location;
        this.remarks = remarks;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public ShipmentStatus getStatus() {
        return status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}