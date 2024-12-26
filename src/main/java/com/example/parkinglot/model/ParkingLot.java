package com.example.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<ParkingSpot> parkingSpots;
    private Map<String, ParkingSpot> occupiedSpots;


    public ParkingLot(int numOfSpots) {
        parkingSpots = new ArrayList<>();
        occupiedSpots = new HashMap<>();
        for (int i = 0; i < numOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(i + 1, ParkingSpotSize.REGULAR));
        }
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.canFit(vehicle)) {
                spot.park(vehicle);
                occupiedSpots.put(vehicle.getLicensePlate(), spot);
                return spot;
            }
        }
        return null;
    }

    public Vehicle retrieveVehicle(String licensePlate) {
        ParkingSpot spot = occupiedSpots.remove(licensePlate);
        if (spot != null) {
            return spot.removeVehicle();
        }
        return null;
    }

    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> availableSpots = new ArrayList<>();
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable()) {
                availableSpots.add(spot);
            }
        }
        return availableSpots;
    }

    public Map<String, ParkingSpot> getOccupiedSpots() {
        return occupiedSpots;
    }

}