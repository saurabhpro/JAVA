package Ch07_Object_Oriented_Design.Q704_ParkingLot.model;

import Ch07_Object_Oriented_Design.Q704_ParkingLot.ParkingSpot;

import java.util.ArrayList;

public abstract class Vehicle {
    private final ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    public int spotsNeeded;
    protected String licensePlate;
    VehicleSize size;

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    /* Park vehicle in this spot (among others, potentially) */
    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    /* Remove car from spot, and notify spot that it's gone */
    public void clearSpots() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public abstract void print();
}
