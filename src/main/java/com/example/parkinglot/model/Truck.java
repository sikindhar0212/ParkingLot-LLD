package com.example.parkinglot.model;

public class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, ParkingSpotSize.LARGE, new TruckPricingStrategy());
    }
}