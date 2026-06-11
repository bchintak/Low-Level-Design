package com.shipment_tracking_system;


import com.shipment_tracking_system.model.Carrier;
import com.shipment_tracking_system.model.Customer;
import com.shipment_tracking_system.model.Location;
import com.shipment_tracking_system.model.TrackingEvent;
import com.shipment_tracking_system.observer.EmailObserver;
import com.shipment_tracking_system.observer.NotificationManager;
import com.shipment_tracking_system.observer.SMSObserver;
import com.shipment_tracking_system.repository.InMemoryShipmentRepository;
import com.shipment_tracking_system.repository.ShipmentRepository;
import com.shipment_tracking_system.service.ShipmentService;

public class Main {

    public static void main(String[] args) {

        ShipmentRepository repository =
                new InMemoryShipmentRepository();

        NotificationManager notificationManager =
                new NotificationManager();

        notificationManager.registerObserver(
                new EmailObserver());

        notificationManager.registerObserver(
                new SMSObserver());

        ShipmentService shipmentService =
                new ShipmentService(
                        repository,
                        notificationManager);

        Customer customer =
                new Customer(
                        "C1",
                        "Bhanu",
                        "bhanu@gmail.com",
                        "9999999999");

        Location source =
                new Location(
                        "Hyderabad",
                        "Telangana",
                        "India",
                        "500001");

        Location destination =
                new Location(
                        "Chennai",
                        "Tamil Nadu",
                        "India",
                        "600001");

        shipmentService.createShipment(
                "SHIP-101",
                source,
                destination,
                customer);

        Carrier carrier =
                new Carrier(
                        "CAR-1",
                        "BlueDart");

        shipmentService.assignCarrier(
                "SHIP-101",
                carrier);

        shipmentService.updateShipmentStatus(
                "SHIP-101",
                source,
                "Package Picked Up");

        shipmentService.updateShipmentStatus(
                "SHIP-101",
                new Location(
                        "Bangalore",
                        "Karnataka",
                        "India",
                        "560001"),
                "Reached Sorting Hub");

        shipmentService.updateShipmentStatus(
                "SHIP-101",
                destination,
                "Out For Delivery");

        shipmentService.updateShipmentStatus(
                "SHIP-101",
                destination,
                "Delivered Successfully");

        System.out.println(
                "\nShipment Details:");

        System.out.println(
                shipmentService.trackShipment(
                        "SHIP-101"));

        System.out.println(
                "\nTracking History:");

        for (TrackingEvent event :
                shipmentService.getTrackingHistory(
                        "SHIP-101")) {

            System.out.println(event);
        }
    }
}
