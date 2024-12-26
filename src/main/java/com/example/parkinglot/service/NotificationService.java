package com.example.parkinglot.service;

import com.example.parkinglot.model.ParkingSpot;

import java.util.List;

public class NotificationService {
    private List<String> userContacts;

    public NotificationService(List<String> userContacts) {
        this.userContacts = userContacts;
    }

    public void notifyAvailableSpots(List<ParkingSpot> availableSpots) {
        if (availableSpots.isEmpty()) {
            System.out.println("No available spots to notify.");
            return;
        }

        for (String contact : userContacts) {
            System.out.println("Notification sent to " + contact + ":");
            System.out.println("Available parking spots: ");
            for (ParkingSpot spot : availableSpots) {
                System.out.println("Spot Number: " + spot.getSpotNumber() + ", Size: " + spot.getSize());
            }
        }
    }
}