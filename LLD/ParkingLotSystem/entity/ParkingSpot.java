package ParkingLotSystem.entity;

import ParkingLotSystem.enums.SpotType;

public class ParkingSpot {
    String spotId;
    SpotType spotType;
    Boolean isOccupied;
    Integer floorNumber;

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpot(String spotId, SpotType spotType, Boolean isOccupied, Integer floorNumber) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = isOccupied;
        this.floorNumber = floorNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
