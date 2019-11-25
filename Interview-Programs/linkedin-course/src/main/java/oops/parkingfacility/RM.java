package oops.parkingfacility;

public class RM extends VehicleParkingDetail {
    private int quantity;

    public RM(int quantity) {
        super(PARKING_SPACE_TYPE.REGULAR, PARKING_SPOT_SIZE.MEDIUM);
        this.quantity = quantity;

    }
}
