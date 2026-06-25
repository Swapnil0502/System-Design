package ParkingLotSystem.service;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.strategies.AllocationStrategy;
import ParkingLotSystem.strategies.FareCalculationStrategy;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ParkingService {

    // TODO:  use concurrent hashmap
    Set<Ticket> tickets = new HashSet<>();


    private final AllocationStrategy allocationStrategy;
    private final FareCalculationStrategy fareCalculationStrategy;

    public ParkingService(AllocationStrategy allocationStrategy, FareCalculationStrategy fareCalculationStrategy) {
        this.allocationStrategy = allocationStrategy;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }
    //park

    public Ticket park(Vehicle vehicle, ParkingLot parkingLot) {

        // TODO : make allocation atomic/thread safe
        ParkingSpot availableSpot = allocationStrategy.allocateSpot(vehicle.getVehicleType(), parkingLot);

        if (availableSpot == null) {
            throw new ParkingFullException("No parking space available");
        }
        availableSpot.setOccupied(true);

        Ticket ticket = new Ticket(vehicle, availableSpot);

        tickets.add(ticket);

        return ticket;
    }

    //unpark

    public Reciept unpark(Ticket ticket){

            if (!tickets.contains(ticket))
            throw new InvalidTicketException("Invalid ticket");

                //free spot
                ticket.getParkingSpot().setOccupied(false);

                //calculate fare
                Double calculatedFare = fareCalculationStrategy.calculateFare(ticket);

                //remove ticket
                tickets.remove(ticket);

                return new Reciept(ticket.getTicketId(), calculatedFare);
    }
}
