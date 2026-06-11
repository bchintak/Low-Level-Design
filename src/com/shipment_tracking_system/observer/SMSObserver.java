package com.shipment_tracking_system.observer;

import com.shipment_tracking_system.enums.ShipmentStatus;

public class SMSObserver
        implements Observer {

    @Override
    public void update(
            String shipmentId,
            ShipmentStatus status) {

        System.out.println(
                "SMS Sent : " + status);
    }
}
