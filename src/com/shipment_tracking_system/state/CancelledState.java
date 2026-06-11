package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public class CancelledState implements ShipmentState {

    @Override
    public void next(Shipment shipment) {

        throw new IllegalStateException(
                "Shipment already cancelled");
    }

    @Override
    public ShipmentStatus getStatus() {
        return ShipmentStatus.CANCELLED;
    }
}
