package com.shipment_tracking_system.state;

import com.shipment_tracking_system.enums.ShipmentStatus;
import com.shipment_tracking_system.model.Shipment;

public class CreatedState implements ShipmentState {

    @Override
    public void next(Shipment shipment) {
        shipment.setState(new PickedUpState());
    }

    @Override
    public ShipmentStatus getStatus() {
        return ShipmentStatus.CREATED;
    }
}