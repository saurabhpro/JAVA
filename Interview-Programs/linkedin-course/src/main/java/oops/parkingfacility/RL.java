package oops.parkingfacility;

public class RL extends VehicleParkingDetail {
    private int quantity;

    public RL(int quantity) {
        super(PARKING_SPACE_TYPE.REGULAR, PARKING_SPOT_SIZE.LARGE);
        this.quantity = quantity;

    }
}
