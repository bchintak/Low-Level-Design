package com.parkinglot;

import com.parkinglot.model.*;
import com.parkinglot.service.ParkingService;
import com.parkinglot.strategy.NearestSlotStrategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ParkingSlot slot1 =
                new ParkingSlot(
                        1,
                        VehicleType.CAR);

        ParkingSlot slot2 =
                new ParkingSlot(
                        2,
                        VehicleType.BIKE);

        ParkingFloor floor =
                new ParkingFloor(
                        1,
                        Arrays.asList(slot1, slot2));

        ParkingLot lot =
                new ParkingLot(
                        Arrays.asList(floor));

        ParkingService service =
                new ParkingService(
                        lot,
                        new NearestSlotStrategy());

        Vehicle car =
                new Car("AP39AB1234");

        Ticket ticket =
                service.parkVehicle(car);

        System.out.println(
                "Ticket Generated : "
                        + ticket.getTicketId());

        double fee =
                service.exitVehicle(ticket);

        System.out.println(
                "Parking Fee : " + fee);
    }
}