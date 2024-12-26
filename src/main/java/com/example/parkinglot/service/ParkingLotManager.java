package com.example.parkinglot.service;

import com.example.parkinglot.model.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private ParkingService parkingService;
    private NotificationService notificationService;
    private ReportService reportService;
    private List<String> userContacts;

    public ParkingLotManager(int numOfSpots, List<String> userContacts) {
        this.parkingService = new ParkingService(numOfSpots);
        this.userContacts = userContacts;
        this.notificationService = new NotificationService(userContacts);
        this.reportService = new ReportService(parkingService.getParkingLot());
    }

    public String parkVehicle(String licensePlate, String vehicleType) {
        Vehicle vehicle = createVehicle(licensePlate, vehicleType);
        ParkingSpot parkedSpot = parkingService.parkVehicle(vehicle);

        if (parkedSpot != null) {
            System.out.println("Vehicle parked successfully in spot number: " + parkedSpot.getSpotNumber());
            return parkedSpot.getSpotNumber() + "";
        } else {
            System.out.println("No available spots for vehicle: " + licensePlate);
            return null;
        }
    }

    public Vehicle retrieveVehicle(String licensePlate) {
        Vehicle vehicle = parkingService.retrieveVehicle(licensePlate);

        if (vehicle != null) {
            System.out.println("Vehicle retrieved successfully: " + vehicle.getLicensePlate());
            return vehicle;
        } else {
            System.out.println("Vehicle not found: " + licensePlate);
            return null;
        }
    }

    public void notifyAvailableSpots() {
        List<ParkingSpot> availableSpots = parkingService.getAvailableSpots();
        notificationService.notifyAvailableSpots(availableSpots);
    }

    public void generateReport() {
        reportService.generateReport();
    }
    private Vehicle createVehicle(String licensePlate, String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car(licensePlate);
            case "bike":
                return new Bike(licensePlate);
            case "truck":
                return new Truck(licensePlate);
            default:
                System.out.println("Unknown vehicle type: " + vehicleType);
                return null;
        }
    }
}