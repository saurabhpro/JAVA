package knightdemo.creational.factorymethod;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;

/**
 * @author saurabh
 */
public class Main {

    public static void main(String[] args) {
        //craete factory
        Factory factory = new MajesticFactory();
        //call the method
        Knight knight = factory.createKnight(KnightWeapon.DOUBLE_SWORD);
        //demonstrate
        System.out.println(knight.getName());
    }
}
