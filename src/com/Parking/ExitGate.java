package com.Parking;

public class ExitGate
{
	private ParkingLot parkingLot;
	
	public ExitGate(ParkingLot parkingLot)
	{
		super();
		this.parkingLot = parkingLot;
	}
	
	public void allowExit(Vehicle v)
	{
		parkingLot.exitVehicle(v);
	}
}
