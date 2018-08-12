package knightdemo.structural.decorator;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;
import knightdemo.model.MajesticKnight;

/**
 * We have a knight writer decorator that writes his story
 */
public class Main {

    public static void main(String[] args) {
        Knight knight = new MajesticKnight();

        KnightWriter knightWriter = new KnightWriter(knight);
        knightWriter.setWeapon(KnightWeapon.DOUBLE_SWORD);
        System.out.println(knightWriter.getName());

        // Knight has given his weapon.
        // Knight has been asked for the name
        // Majestic is my fathers name and so is mine!
    }

}
