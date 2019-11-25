package oops.parkingfacility;

public class HS extends VehicleParkingDetail {
    private int quantity;

    public HS(int quantity) {
        super(PARKING_SPACE_TYPE.HANDICAPPED, PARKING_SPOT_SIZE.SMALL);
        this.quantity = quantity;

    }
}
