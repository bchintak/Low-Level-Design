package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public class OutForDeliveryState implements ShipmentState {

    @Override
    public void next(Shipment shipment) {
        shipment.setState(new DeliveredState());
    }

    @Override
    public ShipmentStatus getStatus() {
        return ShipmentStatus.OUT_FOR_DELIVERY;
    }
}
