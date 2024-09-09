package com.Parking;

import java.util.*;
import java.util.Map.Entry;

public class ParkingLot {
	private int capacity;
	private int nextSlot;
	Scanner sc = new Scanner(System.in);

	public ParkingLot() {
		super();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNextSlot() {
		return nextSlot;
	}

	public void setNextSlot(int nextSlot) {
		this.nextSlot = nextSlot;
	}

	public void parkVehicle(Vehicle v) {

		if (nextSlot == 0) {
			System.out.println("Sorry, Slot not available here...");
			return;
		}

		// vehicle class
		System.out.println("Enter vehicle Plate Number: ");
		v.setPlateNumber(sc.nextLine().toUpperCase());
		System.out.println("Enter vehicle Type: ");
		String type = sc.nextLine().toLowerCase();
		if (type.equals("bike")) {
			v.setType(VehicleType.BIKE);
		} else if (type.equals("car")) {
			v.setType(VehicleType.CAR);
		} else {
			v.setType(VehicleType.TRUCK);
		}
		if (!ParkingFile.parkedVehicles.keySet().contains(v.getPlateNumber())) {
			ParkingFile.parkedVehicles.put(v.getPlateNumber(), nextSlot--);
			

		}
		else if(ParkingFile.parkedVehicles.values().stream().count()!=capacity)
			{			
				ParkingFile.parkedVehicles.put(v.getPlateNumber(), nextSlot);
			}
		else 
		{
			System.out.println("can not add duplicate data");
			return;
		}
			
//		--nextSlot;
		
		System.out.println(v.getType() + " parked successfully. Available slots: " + nextSlot);

	}

	public void exitVehicle(Vehicle v) 
	{
		
		if (nextSlot > capacity && nextSlot == 0) {
			System.out.println("There is no parked Vehicle.");
		}

		System.out.println("Please, enter vehicle plate Number: ");
		v.setPlateNumber(sc.nextLine().toLowerCase());
		String plateNumber = v.getPlateNumber();
		if (ParkingFile.parkedVehicles.containsKey(plateNumber)) {
		 nextSlot = ParkingFile.parkedVehicles.remove(v.getPlateNumber());
		
//			nextSlot++;
			

			System.out.println(v.getType() + " removed successfully. Available slots: " + nextSlot);
		} else {
			System.out.println("Vehicle is not parked here.");
		}
		
	}

	public void findVehicle(String s) {
		if (nextSlot == capacity) {
			System.out.println("There is no parked Vehicle");
			return;
		}

//		Set<String> plateNumbers = parkedVehicles.keySet();
		Set<Entry<String, Integer>> entrySet = ParkingFile.parkedVehicles.entrySet();

//		System.out.println(entrySet);
		for (Entry<String, Integer> pNumber : entrySet) {
			if (pNumber.getKey().equalsIgnoreCase(s))
			{
				System.out.println("!! " + pNumber.getKey() + " !!" + " Slot " + pNumber.getValue());
			}
		}
	}
	public void showParking()
	{
		System.out.println("**********Parking Lot**********");
		ParkingFile.parkedVehicles.forEach((k,v)->System.out.println("\t"+k+" :: "+v));
	}
}
