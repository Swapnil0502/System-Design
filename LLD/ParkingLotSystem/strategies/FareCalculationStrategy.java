package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.Ticket;

public interface FareCalculationStrategy {

    Double calculateFare(Ticket ticket);
}
