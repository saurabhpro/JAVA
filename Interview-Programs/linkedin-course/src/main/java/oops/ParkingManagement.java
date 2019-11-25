package oops;

import oops.parkingfacility.HM;
import oops.parkingfacility.RL;
import oops.parkingfacility.RM;
import oops.parkingfacility.RS;
import oops.parkinglot.ParkingInventory;

public class ParkingManagement {
    public static void main(String[] args) {

        RS rs = new RS(9);
        RL rl = new RL(10);
        RM rm = new RM(24);
        HM hm = new HM(5);

        ParkingInventory parkingInventory = new ParkingInventory();

    }
}
