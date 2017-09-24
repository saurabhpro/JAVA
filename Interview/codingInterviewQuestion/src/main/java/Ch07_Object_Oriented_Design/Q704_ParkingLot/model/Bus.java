package Ch07_Object_Oriented_Design.Q704_ParkingLot.model;

import Ch07_Object_Oriented_Design.Q704_ParkingLot.ParkingSpot;

public class Bus extends Vehicle {
	public Bus() {
		spotsNeeded = 5;
		size = VehicleSize.Large;
	}

	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Large;
	}

	public void print() {
		System.out.print("B");
	}
}
