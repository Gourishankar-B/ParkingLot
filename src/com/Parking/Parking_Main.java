package com.Parking;

import java.util.Scanner;

public class Parking_Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Vehicle vehicle = new Vehicle();
		ParkingLot pl = new ParkingLot();
		
		System.out.println("Enter the capicity: ");
		pl.setCapacity(Integer.parseInt(sc.nextLine()));
		pl.setNextSlot(pl.getCapacity());
		
		while (true) {
			System.out.println("\n*******parking Lot********");
			System.out.println("press 1 for enter parking");
			System.out.println("press 2 for exit parking");
			System.out.println("press 3 for find Vehicle in parking");
			System.out.println("press 4 for show parking");
			System.out.println("press 5 for exit app");

			
			System.out.println("Enter your choice: ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				new EntryGate(pl).allowEntry(vehicle);
				break;
				
			case 2:
				new ExitGate(pl).allowExit(vehicle);
				break;
				
			case 3:
				System.out.println("Enter Parked vehicle Plate Number: ");
				String plateNumber = sc.nextLine().toLowerCase();
				pl.findVehicle(plateNumber);
				break;
				
			case 4:
				pl.showParking();
				break;
			case 5: 
				System.exit(0);
				System.out.println("System exit successfully");
			
			default: 
				System.out.println("Invalid option...."); 
			
			}
		}

	}
}
