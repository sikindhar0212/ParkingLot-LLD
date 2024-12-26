package com.example.parkinglot.model;

public abstract class Vehicle {
    private String licensePlate;
    private ParkingSpotSize size;
    private PricingStrategy pricingStrategy;

    public Vehicle(String licensePlate, ParkingSpotSize size, PricingStrategy pricingStrategy) {
        this.licensePlate = licensePlate;
        this.size = size;
        this.pricingStrategy = pricingStrategy;
    }

    public String getLicensePlate() {

        return licensePlate;
    }

    public ParkingSpotSize getSize() {

        return size;
    }

    public PricingStrategy getPricingStrategy() {

        return pricingStrategy;
    }
}