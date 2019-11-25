package oops.parkingfacility;

public class HM extends VehicleParkingDetail {
    private int quantity;

    public HM(int quantity) {
        super(PARKING_SPACE_TYPE.HANDICAPPED, PARKING_SPOT_SIZE.MEDIUM);
        this.quantity = quantity;

    }
}

