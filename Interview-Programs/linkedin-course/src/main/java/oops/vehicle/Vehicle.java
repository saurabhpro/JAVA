package oops.vehicle;

import oops.parkingfacility.PARKING_SPOT_SIZE;
import oops.parkingfacility.VehicleParkingDetail;

public abstract class Vehicle {
    private VehicleParkingDetail sizeCategory;

    public Vehicle(VehicleParkingDetail sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public boolean canFitInSmallParkingLot() {
        return sizeCategory.getParkingSpotSize() == PARKING_SPOT_SIZE.SMALL;
    }

    public boolean canFitInRegularParkingLot() {
        return sizeCategory.getParkingSpotSize() != PARKING_SPOT_SIZE.LARGE;
    }

    public boolean canFitInLargeParkingLot() {
        return true;
    }
}
