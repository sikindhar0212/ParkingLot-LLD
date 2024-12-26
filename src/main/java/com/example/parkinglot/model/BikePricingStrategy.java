package com.example.parkinglot.model;

public class BikePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(int hours) {
        return hours * 1.0;
    }
}
