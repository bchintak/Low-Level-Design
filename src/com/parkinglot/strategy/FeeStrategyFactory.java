package com.parkinglot.strategy;

import com.parkinglot.model.VehicleType;

public class FeeStrategyFactory {

    public static FeeStrategy getStrategy(
            VehicleType vehicleType) {

        switch (vehicleType) {

            case CAR:
                return new CarFeeStrategy();

            case BIKE:
                return new BikeFeeStrategy();

            case TRUCK:
                return new TruckFeeStrategy();

            default:
                throw new IllegalArgumentException(
                        "Invalid vehicle type");
        }
    }
}
