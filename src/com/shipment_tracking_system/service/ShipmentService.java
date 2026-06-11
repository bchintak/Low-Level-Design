package com.shipment_tracking_system.service;

import com.shipment_tracking_system.model.Carrier;
import com.shipment_tracking_system.model.Customer;
import com.shipment_tracking_system.model.Location;
import com.shipment_tracking_system.model.Shipment;
import com.shipment_tracking_system.model.TrackingEvent;
import com.shipment_tracking_system.observer.NotificationManager;
import com.shipment_tracking_system.repository.ShipmentRepository;

import java.time.LocalDateTime;
import java.util.List;

public class ShipmentService {

    private final ShipmentRepository repository;

    private final NotificationManager notificationManager;

    public ShipmentService(
            ShipmentRepository repository,
            NotificationManager notificationManager) {

        this.repository = repository;
        this.notificationManager = notificationManager;
    }

    /**
     * Create Shipment
     */
    public Shipment createShipment(
            String shipmentId,
            Location source,
            Location destination,
            Customer customer) {

        Shipment shipment =
                new Shipment(
                        shipmentId,
                        source,
                        destination,
                        customer);

        shipment.addTrackingEvent(
                new TrackingEvent(
                        LocalDateTime.now(),
                        shipment.getCurrentStatus(),
                        source,
                        "Shipment Created"));

        repository.save(shipment);

        return shipment;
    }

    /**
     * Assign Carrier
     */
    public void assignCarrier(
            String shipmentId,
            Carrier carrier) {

        Shipment shipment =
                repository.findById(shipmentId);

        shipment.assignCarrier(carrier);

        repository.save(shipment);
    }

    /**
     * Update Shipment Status
     */
    public void updateShipmentStatus(
            String shipmentId,
            Location currentLocation,
            String remarks) {

        Shipment shipment =
                repository.findById(shipmentId);

        shipment.moveToNextState();

        shipment.addTrackingEvent(
                new TrackingEvent(
                        LocalDateTime.now(),
                        shipment.getCurrentStatus(),
                        currentLocation,
                        remarks));

        repository.save(shipment);

        notificationManager.notifyObservers(
                shipmentId,
                shipment.getCurrentStatus());
    }

    /**
     * Cancel Shipment
     */
    public void cancelShipment(
            String shipmentId,
            Location currentLocation,
            String remarks) {

        Shipment shipment =
                repository.findById(shipmentId);

        shipment.cancelShipment();

        shipment.addTrackingEvent(
                new TrackingEvent(
                        LocalDateTime.now(),
                        shipment.getCurrentStatus(),
                        currentLocation,
                        remarks));

        repository.save(shipment);

        notificationManager.notifyObservers(
                shipmentId,
                shipment.getCurrentStatus());
    }

    /**
     * Track Shipment
     */
    public Shipment trackShipment(
            String shipmentId) {

        return repository.findById(
                shipmentId);
    }

    /**
     * Tracking History
     */
    public List<TrackingEvent> getTrackingHistory(
            String shipmentId) {

        Shipment shipment =
                repository.findById(shipmentId);

        return shipment.getTrackingEvents();
    }

    /**
     * Get All Shipments
     */
    public List<Shipment> getAllShipments() {
        return repository.findAll();
    }
}