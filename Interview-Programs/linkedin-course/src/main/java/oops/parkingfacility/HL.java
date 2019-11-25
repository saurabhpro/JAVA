package oops.parkingfacility;

public class HL extends VehicleParkingDetail {
    private int quantity;

    public HL(int quantity) {
        super(PARKING_SPACE_TYPE.HANDICAPPED, PARKING_SPOT_SIZE.LARGE);
        this.quantity = quantity;
    }
}
