package ParkingLotSystem.client;

import ParkingLotSystem.entity.*;
import ParkingLotSystem.enums.SpotType;
import ParkingLotSystem.enums.VehicleType;
import ParkingLotSystem.exception.InvalidTicketException;
import ParkingLotSystem.exception.ParkingFullException;
import ParkingLotSystem.strategies.FirstAvailableAllocationStrategy;
import ParkingLotSystem.strategies.HourlyFareCalculationStrategy;
import ParkingLotSystem.service.ParkingService;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        //vehicles
        Vehicle bike1 = new Vehicle("UP652021", VehicleType.BIKE);
        Vehicle bike2 = new Vehicle("UP652022", VehicleType.BIKE);
        Vehicle bike3 = new Vehicle("UP652023", VehicleType.BIKE);
        Vehicle car1 = new Vehicle("UP652024", VehicleType.CAR);
        List<Vehicle> vehicles = List.of(bike1, bike2, bike3, car1);

        //parking floors
        ParkingFloor floor1 = new ParkingFloor(List.of(
                new ParkingSpot("S-101", SpotType.BIKE, false, 1),
                new ParkingSpot("S-102", SpotType.CAR, false, 1),
                new ParkingSpot("S-103", SpotType.TRUCK, false, 1)
        ));

        ParkingFloor floor2 = new ParkingFloor(List.of(
                new ParkingSpot("S-101", SpotType.BIKE, false, 2),
                new ParkingSpot("S-102", SpotType.CAR, false, 2),
                new ParkingSpot("S-103", SpotType.TRUCK, false, 2)
        ));

        //parking lot
        ParkingLot parkingLot = ParkingLot.getInstance(List.of(floor1, floor2));

        ParkingService parkingService = new ParkingService(new FirstAvailableAllocationStrategy(), new HourlyFareCalculationStrategy());
        Ticket ticketBike = null, ticketBike1 = null, ticketBike2 = null, ticketCar = null;

        try {
            ticketBike = parkingService.park(bike1, parkingLot);
            if (ticketBike != null)
                System.out.println("Parked bike1 " + ticketBike);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            ticketBike1 = parkingService.park(bike2, parkingLot);
            if (ticketBike1 != null)
                System.out.println("Parked bike2 " + ticketBike1);

        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Reciept reciept = parkingService.unpark(null);
            System.out.println("Unparked bike1 " + reciept);
        } catch (InvalidTicketException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            ticketBike2 = parkingService.park(bike3, parkingLot);
            if (ticketBike2 != null)
                System.out.println("Parked bike3 " + ticketBike2);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        }


        try {
            ticketCar = parkingService.park(car1, parkingLot);
            if (ticketCar != null)
                System.out.println("Parked car1 " + ticketCar);
        } catch (ParkingFullException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
