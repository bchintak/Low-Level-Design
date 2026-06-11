package com.shipment_tracking_system.observer;

import com.shipment_tracking_system.enums.ShipmentStatus;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {

    private final List<Observer>
            observers = new ArrayList<>();

    public void registerObserver(
            Observer observer) {

        observers.add(observer);
    }

    public void removeObserver(
            Observer observer) {

        observers.remove(observer);
    }

    public void notifyObservers(
            String shipmentId,
            ShipmentStatus status) {

        for (Observer observer : observers) {
            observer.update(
                    shipmentId,
                    status);
        }
    }
}