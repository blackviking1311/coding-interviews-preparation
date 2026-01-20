package org.example.lowleveldesign.implementations.parkinglot.strategy.fee;

import org.example.lowleveldesign.implementations.parkinglot.entities.ParkingTicket;

public class FlatRateFeeStrategy implements FeeStrategy {

    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(ParkingTicket parkingTicket) {
        long duration = parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp();
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return hours * RATE_PER_HOUR;
    }
}