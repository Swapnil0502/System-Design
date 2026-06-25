package ParkingLotSystem.entity;

import java.util.List;

public class ParkingFloor {
    List<ParkingSpot>parkingSpots;

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public ParkingFloor(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
