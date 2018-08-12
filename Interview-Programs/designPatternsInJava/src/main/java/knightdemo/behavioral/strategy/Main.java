package knightdemo.behavioral.strategy;

/**
 * Strategy pattern example
 *
 * @author saurabh
 */
public class Main {

    public static void main(String[] args) {
        StrategyKnight knight = new StrategyHolyKnight();
        knight.setStrategy(new ArmorResponseStrategy());
        knight.reduceArmor(0.1);

        knight.setStrategy(new GodlyArmorResponseStrategy());
        knight.reduceArmor(0.1);
    }
}
