package ParkingLotSystem.entity;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot;

    private ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(List<ParkingFloor> parkingFloors){
        if(parkingLot == null)
        {
            parkingLot = new ParkingLot(parkingFloors);
        }

            return parkingLot;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
