package ParkingLotSystem.entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    LocalDateTime dateTime;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }

//    ticket should not be modified later
//    public void setTicketId(String ticketId) {
//        this.ticketId = ticketId;
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(ticketId, ticket.ticketId);
    }

    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle.vehicleNumber +
                ", parkingSpot=" + parkingSpot.spotId +
                ", parkingFloor=" + parkingSpot.floorNumber +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketId);
    }

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.dateTime = LocalDateTime.now();
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
