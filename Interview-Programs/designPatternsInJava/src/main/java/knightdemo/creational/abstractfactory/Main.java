package knightdemo.creational.abstractfactory;

import knightdemo.model.Knight;
import knightdemo.model.KnightFamily;

/**
 * @author saurabh
 */
public class Main {

    public static void main(String[] args) {
        //Create factory
        Factory factory = FactoryProducer.getFactory(KnightFamily.MAJESTIC);
        //create knight
        Knight knight = factory != null ? factory.getKnight() : null;
        //demonstrate that all is ok
        System.out.println(knight != null ? knight.getName() : null);
    }
}