package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.ParkingLot;
import ParkingLotSystem.entity.ParkingSpot;
import ParkingLotSystem.enums.VehicleType;

import java.util.List;

public interface AllocationStrategy {
    ParkingSpot allocateSpot(VehicleType vehicleType, ParkingLot parkingLot);
}
