package com.shipment_tracking_system.repository;

import com.shipment_tracking_system.model.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryShipmentRepository
        implements ShipmentRepository {

    private final Map<String, Shipment> shipmentStore =
            new ConcurrentHashMap<>();

    @Override
    public void save(Shipment shipment) {

        shipmentStore.put(
                shipment.getShipmentId(),
                shipment);
    }

    @Override
    public Shipment findById(String shipmentId) {

        Shipment shipment =
                shipmentStore.get(shipmentId);

        if (shipment == null) {
            throw new IllegalArgumentException(
                    "Shipment not found: " + shipmentId);
        }

        return shipment;
    }

    @Override
    public List<Shipment> findAll() {
        return new ArrayList<>(
                shipmentStore.values());
    }

    @Override
    public void delete(String shipmentId) {

        shipmentStore.remove(shipmentId);
    }
}
