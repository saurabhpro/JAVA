package knightdemo.structural.privateclassdata;

import knightdemo.model.KnightWeapon;

/**
 * @author saurabh
 * <p>
 * Demonstration of private class data pattern where using PrivateHolyKnight class we are unable to use all of the knight potential
 */
public class Main {

    public static void main(String[] args) {
        PrivateHolyKnight holyKnight = new PrivateHolyKnight(KnightWeapon.DOUBLE_SWORD);
        System.out.println(holyKnight.getName() + " " + holyKnight.getDamage());
        // Holy Knight is my name! 19
    }

}
