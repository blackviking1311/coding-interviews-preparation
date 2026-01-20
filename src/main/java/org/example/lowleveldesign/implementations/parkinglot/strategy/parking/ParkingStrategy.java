package org.example.lowleveldesign.implementations.parkinglot.strategy.parking;

import org.example.lowleveldesign.implementations.parkinglot.entities.ParkingFloor;
import org.example.lowleveldesign.implementations.parkinglot.entities.ParkingSpot;
import org.example.lowleveldesign.implementations.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
