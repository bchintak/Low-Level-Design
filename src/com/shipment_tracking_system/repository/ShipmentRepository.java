package com.shipment_tracking_system.repository;

import com.shipment_tracking_system.model.Shipment;

import java.util.List;

public interface ShipmentRepository {

    void save(Shipment shipment);

    Shipment findById(String shipmentId);

    List<Shipment> findAll();

    void delete(String shipmentId);
}
