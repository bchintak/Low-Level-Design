package com.shipment_tracking_system.observer;

import com.shipment_tracking_system.enums.ShipmentStatus;

public class EmailObserver
        implements Observer {

    @Override
    public void update(
            String shipmentId,
            ShipmentStatus status) {

        System.out.println(
                "Email Sent : " + status);
    }
}
