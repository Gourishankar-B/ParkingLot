package com.Parking;

import java.util.Objects;

public class Vehicle 
{
	private String plateNumber;
	private VehicleType type;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String plateNumber, VehicleType type) {
		super();
		this.plateNumber = plateNumber;
		this.type = type;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		return Objects.hash(plateNumber, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(plateNumber, other.plateNumber) && type == other.type;
	}

	
	
}
