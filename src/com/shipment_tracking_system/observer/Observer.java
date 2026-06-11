package com.shipment_tracking_system.observer;

import com.shipment_tracking_system.enums.ShipmentStatus;

public interface Observer {

    void update(
            String shipmentId,
            ShipmentStatus status);
}
