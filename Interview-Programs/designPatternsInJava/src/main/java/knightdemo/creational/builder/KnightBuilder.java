package knightdemo.creational.builder;

import knightdemo.model.HolyKnight;
import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;
import knightdemo.model.MajesticKnight;

/**
 * @author saurabh
 */
public class KnightBuilder {
    private Knight knight = null;

    /**
     * @return Knight
     */
    public Knight getKnight() {
        return knight;
    }

    /**
     * Creates  HolyKnight
     */
    public void createFightingHolyKnight() {
        knight = new HolyKnight();
        knight.setWeapon(KnightWeapon.DOUBLE_SWORD);
    }

    /**
     * Creates MajesticKnight
     */
    public void createFightingMajesticKnight() {
        knight = new MajesticKnight();
        knight.setWeapon(KnightWeapon.SWORD);
    }
}
