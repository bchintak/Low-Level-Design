package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public class InTransitState implements ShipmentState {

    @Override
    public void next(Shipment shipment) {
        shipment.setState(new OutForDeliveryState());
    }

    @Override
    public ShipmentStatus getStatus() {
        return ShipmentStatus.IN_TRANSIT;
    }
}
