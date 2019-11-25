package oops.parkingfacility;

public abstract class VehicleParkingDetail {
    private PARKING_SPACE_TYPE isRegular;
    private PARKING_SPOT_SIZE parkingSpotSize;
//	private int quantity;

    public VehicleParkingDetail(PARKING_SPACE_TYPE isRegular, PARKING_SPOT_SIZE parkingSpotSize) {
        this.isRegular = isRegular;
        this.parkingSpotSize = parkingSpotSize;
        //	this.quantity = quantity;
    }

    public PARKING_SPACE_TYPE isRegular() {
        return isRegular;
    }

    public PARKING_SPOT_SIZE getParkingSpotSize() {
        return parkingSpotSize;
    }

    public abstract boolean hasSpace(int amount);
}
