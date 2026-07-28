package ParkingLotSystem.service;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.strategies.AllocationStrategy;
import ParkingLotSystem.strategies.FareCalculationStrategy;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingService {

    // TODO:  use concurrent hashmap
    Map<String, Ticket> tickets = new ConcurrentHashMap<>();


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


        Ticket ticket = new Ticket(vehicle, availableSpot);

        tickets.putIfAbsent(ticket.getTicketId(), ticket);

        return ticket;
    }

    //unpark

    public Reciept unpark(Ticket ticket){

        Ticket activeTicket = tickets.remove(ticket.getTicketId());

            //remove ticket
            if (activeTicket == null)
            throw new InvalidTicketException("Invalid ticket");

                //free spot
                activeTicket.getParkingSpot().release();

                //calculate fare
                Double calculatedFare = fareCalculationStrategy.calculateFare(activeTicket);

                return new Reciept(ticket.getTicketId(), calculatedFare);
    }
}
