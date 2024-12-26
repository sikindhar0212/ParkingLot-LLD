package com.example.parkinglot.model;

public class CarPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(int hours) {
        return hours * 2.0;
    }
}
