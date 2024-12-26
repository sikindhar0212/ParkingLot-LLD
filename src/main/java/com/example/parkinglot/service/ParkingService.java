package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.Vehicle;
import com.example.parkinglot.model.ParkingSpot;

import java.util.List;

public class ParkingService {
    private ParkingLot parkingLot;

    public ParkingService(int numOfSpots) {
        parkingLot = new ParkingLot(numOfSpots);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }

    public Vehicle retrieveVehicle(String licensePlate) {
        return parkingLot.retrieveVehicle(licensePlate);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
    public List<ParkingSpot> getAvailableSpots() {

        return parkingLot.getAvailableSpots();
    }

    public double calculatePrice(String licensePlate, int hours) {
        Vehicle vehicle = parkingLot.retrieveVehicle(licensePlate);
        if (vehicle != null) {
            return vehicle.getPricingStrategy().calculatePrice(hours);
        }
        return 0.0;
    }
}