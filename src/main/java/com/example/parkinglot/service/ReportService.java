package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingLot;
import com.example.parkinglot.model.ParkingSpot;
import com.example.parkinglot.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    private ParkingLot parkingLot;

    public ReportService(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void generateReport() {
        int totalVehicles = parkingLot.getOccupiedSpots().size();
        Map<String, Integer> vehicleCount = new HashMap<>();


        for (ParkingSpot spot : parkingLot.getOccupiedSpots().values()) {
            Vehicle vehicle = spot.getVehicle();
            vehicleCount.put(vehicle.getClass().getSimpleName(), vehicleCount.getOrDefault(vehicle.getClass().getSimpleName(), 0) + 1);
        }

        System.out.println("Parking Report:");
        System.out.println("Total Vehicles Parked: " + totalVehicles);
        System.out.println("Vehicles Count by Type:");
        for (Map.Entry<String, Integer> entry : vehicleCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}