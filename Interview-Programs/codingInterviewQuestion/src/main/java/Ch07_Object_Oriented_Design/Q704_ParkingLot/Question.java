package Ch07_Object_Oriented_Design.Q704_ParkingLot;

import Ch07_Object_Oriented_Design.Q704_ParkingLot.model.Bus;
import Ch07_Object_Oriented_Design.Q704_ParkingLot.model.Car;
import Ch07_Object_Oriented_Design.Q704_ParkingLot.model.Motorcycle;
import Ch07_Object_Oriented_Design.Q704_ParkingLot.model.Vehicle;
import CtCILibrary.AssortedMethods;

public class Question {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        Vehicle v = null;

        while (v == null || lot.parkVehicle(v)) {
            lot.print();
            int r = AssortedMethods.randomIntInRange(0, 10);
            if (r < 2) {
                v = new Bus();
            } else if (r < 4) {
                v = new Motorcycle();
            } else {
                v = new Car();
            }
            System.out.print("\nParking a ");
            v.print();
            System.out.println("");
        }
        System.out.println("Parking Failed. Final state: ");
        lot.print();
    }

}
