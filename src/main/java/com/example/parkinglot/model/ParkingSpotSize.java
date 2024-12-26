package com.example.parkinglot.model;

public enum ParkingSpotSize {
    COMPACT, REGULAR, LARGE;

    public boolean canFit(ParkingSpotSize vehicleSize) {
        return this.ordinal() >= vehicleSize.ordinal();
    }
}