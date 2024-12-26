package com.example.parkinglot.model;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, ParkingSpotSize.COMPACT, new BikePricingStrategy());
    }
}