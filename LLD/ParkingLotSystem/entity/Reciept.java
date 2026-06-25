package ParkingLotSystem.entity;

public class Reciept {
    public String getTicketId() {
        return ticketId;
    }

    public Reciept(String ticketId, Double fare) {
        this.ticketId = ticketId;
        this.fare = fare;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String toString() {
        return "Reciept{" +
                "ticketId='" + ticketId + '\'' +
                ", fare=" + fare +
                '}';
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    String ticketId;
    Double fare;
}
