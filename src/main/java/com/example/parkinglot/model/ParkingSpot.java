package com.example.parkinglot.model;

public class ParkingSpot {
    private int spotNumber;
    private Vehicle vehicle;
    private ParkingSpotSize size;

    public ParkingSpot(int spotNumber, ParkingSpotSize size) {
        this.spotNumber = spotNumber;
        this.size = size;
        this.vehicle = null;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFit(Vehicle vehicle) {
        return isAvailable() && this.size.canFit(vehicle.getSize());
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle removeVehicle() {
        Vehicle temp = vehicle;
        vehicle = null;
        return temp;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

     public ParkingSpotSize getSize() {

        return size;
     }

    public Vehicle getVehicle() {

        return vehicle;
    }
}