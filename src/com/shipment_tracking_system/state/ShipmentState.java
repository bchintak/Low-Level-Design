package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public interface ShipmentState {
    void next(Shipment shipment);

    ShipmentStatus getStatus();
}
