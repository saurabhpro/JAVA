package Ch07_Object_Oriented_Design.Q704_ParkingLot.model;

import Ch07_Object_Oriented_Design.Q704_ParkingLot.ParkingSpot;

public class Motorcycle extends Vehicle {
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return true;
	}

	public void print() {
		System.out.print("M");
	}
}
