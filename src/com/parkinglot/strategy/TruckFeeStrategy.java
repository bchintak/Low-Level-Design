package com.parkinglot.strategy;

import com.parkinglot.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class TruckFeeStrategy
        implements FeeStrategy {

    @Override
    public double calculateFee(
            Ticket ticket,
            LocalDateTime exitTime) {

        long hours = Duration.between(
                ticket.getEntryTime(),
                exitTime).toHours();

        hours = Math.max(1, hours);

        return hours * 50;
    }
}
