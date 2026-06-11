package com.shipment_tracking_system.model;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.state.CancelledState;
import com.shipment_tracking_system.state.CreatedState;
import com.shipment_tracking_system.state.DeliveredState;
import com.shipment_tracking_system.state.ShipmentState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shipment {

    private final String shipmentId;

    private final Location source;

    private final Location destination;

    private final Customer customer;

    private Carrier carrier;

    private ShipmentState currentState;

    private final List<TrackingEvent> trackingEvents;

    public Shipment(String shipmentId,
                    Location source,
                    Location destination,
                    Customer customer) {

        this.shipmentId = shipmentId;
        this.source = source;
        this.destination = destination;
        this.customer = customer;

        this.currentState = new CreatedState();
        this.trackingEvents = new ArrayList<>();
    }

    /**
     * Move shipment to next valid state.
     */
    public synchronized void moveToNextState() {
        currentState.next(this);
    }

    /**
     * Cancel shipment.
     */
    public synchronized void cancelShipment() {

        if (currentState instanceof DeliveredState) {
            throw new IllegalStateException(
                    "Delivered shipment cannot be cancelled");
        }

        if (currentState instanceof CancelledState) {
            throw new IllegalStateException(
                    "Shipment already cancelled");
        }

        this.currentState = new CancelledState();
    }

    /**
     * State transition helper used by State classes.
     */
    public synchronized void setState(ShipmentState state) {
        this.currentState = state;
    }

    /**
     * Add tracking history event.
     */
    public synchronized void addTrackingEvent(
            TrackingEvent trackingEvent) {

        trackingEvents.add(trackingEvent);
    }

    /**
     * Returns current shipment status.
     */
    public ShipmentStatus getCurrentStatus() {
        return currentState.getStatus();
    }

    /**
     * Assign carrier.
     */
    public void assignCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    // ==========================
    // Getters
    // ==========================

    public String getShipmentId() {
        return shipmentId;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public ShipmentState getCurrentState() {
        return currentState;
    }

    public List<TrackingEvent> getTrackingEvents() {
        return Collections.unmodifiableList(trackingEvents);
    }

    @Override
    public String toString() {

        return "Shipment{" +
                "shipmentId='" + shipmentId + '\'' +
                ", source=" + source +
                ", destination=" + destination +
                ", customer=" + customer.getName() +
                ", carrier=" +
                (carrier != null ? carrier.getName() : "Not Assigned") +
                ", status=" + getCurrentStatus() +
                '}';
    }
}