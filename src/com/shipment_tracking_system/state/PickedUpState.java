package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public class PickedUpState implements ShipmentState {

    @Override
    public void next(Shipment shipment) {
        shipment.setState(new InTransitState());
    }

    @Override
    public ShipmentStatus getStatus() {
        return ShipmentStatus.PICKED_UP;
    }
}
