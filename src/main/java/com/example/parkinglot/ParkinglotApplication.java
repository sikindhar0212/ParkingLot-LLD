package com.example.parkinglot;

import com.example.parkinglot.service.ParkingLotManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ParkinglotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkinglotApplication.class, args);
		List<String> userContacts = Arrays.asList("user1@example.com", "user2@example.com");
		ParkingLotManager parkingLotManager = new ParkingLotManager(10, userContacts);

		parkingLotManager.parkVehicle("ABC123", "Car");
		parkingLotManager.parkVehicle("XYZ789", "Bike");

		parkingLotManager.notifyAvailableSpots();

		parkingLotManager.retrieveVehicle("ABC123");

		parkingLotManager.generateReport();
	}

}
