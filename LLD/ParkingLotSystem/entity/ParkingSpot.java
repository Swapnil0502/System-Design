package ParkingLotSystem.entity;

import ParkingLotSystem.enums.SpotType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    String spotId;
    SpotType spotType;
    private final AtomicBoolean occupied = new AtomicBoolean(false);
    Integer floorNumber;

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public AtomicBoolean isOccupied() {
        return occupied;
    }

    public Boolean reserve() {
        return occupied.compareAndSet(false, true);
    }
    public void release(){
        occupied.set(false);
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpot(String spotId, SpotType spotType, Integer floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floorNumber = floorNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
