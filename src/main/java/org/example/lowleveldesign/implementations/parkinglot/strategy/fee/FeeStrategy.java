package org.example.lowleveldesign.implementations.parkinglot.strategy.fee;

import org.example.lowleveldesign.implementations.parkinglot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
