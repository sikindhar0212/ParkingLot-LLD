package com.example.parkinglot.model;

public class TruckPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(int hours) {
        return hours * 3.0;
    }
}
