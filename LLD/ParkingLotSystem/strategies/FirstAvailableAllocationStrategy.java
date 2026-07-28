package ParkingLotSystem.strategies;

import ParkingLotSystem.entity.ParkingFloor;
import ParkingLotSystem.entity.ParkingLot;
import ParkingLotSystem.entity.ParkingSpot;
import ParkingLotSystem.enums.VehicleType;

public class FirstAvailableAllocationStrategy implements AllocationStrategy {

    @Override
    public ParkingSpot allocateSpot(VehicleType vehicleType, ParkingLot parkingLot){
        for(ParkingFloor floor : parkingLot.getParkingFloors()){
            for(ParkingSpot spot: floor.getParkingSpots()){
                if(spot.getSpotType().name().equals(vehicleType.name()) && spot.reserve()){
                    return spot;
                }
            }
        }
        return null;
    }
}
