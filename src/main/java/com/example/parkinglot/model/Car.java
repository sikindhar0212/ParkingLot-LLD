package com.example.parkinglot.model;

public class Car extends Vehicle {
    public Car(String licensePlate) {

        super(licensePlate, ParkingSpotSize.REGULAR, new CarPricingStrategy());
    }
}