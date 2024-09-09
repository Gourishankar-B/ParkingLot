package com.Parking;

public class EntryGate 
{
	private ParkingLot parkingLot;
	
	public EntryGate(ParkingLot parkingLot) 
	{
		super();
		this.parkingLot = parkingLot;
	}
 
	public void allowEntry(Vehicle v)
	{
		parkingLot.parkVehicle(v);
	}
}
