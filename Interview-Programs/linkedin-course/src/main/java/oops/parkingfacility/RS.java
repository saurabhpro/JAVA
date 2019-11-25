package oops.parkingfacility;

public class RS extends VehicleParkingDetail {
    private int quantity;

    public RS(int quantity) {
        super(PARKING_SPACE_TYPE.REGULAR, PARKING_SPOT_SIZE.SMALL);
        this.quantity = quantity;

    }
}


