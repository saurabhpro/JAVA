package knightdemo.structural.proxy;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;
import knightdemo.model.MajesticKnight;

public class MajesticKnightProxy implements Knight {

    private Knight knight = null;

    private Knight getKnight() {
        if (knight == null) {
            System.out.println("On Request knight creation ...");
            knight = new MajesticKnight();
        }
        return knight;
    }

    public String getName() {
        return getKnight().getName();
    }

    public Knight cloneKnight() throws CloneNotSupportedException {
        return getKnight().cloneKnight();
    }

    public Integer getDamage() {
        return getKnight().getDamage();
    }

    public void readQuest(String questDetails) {
        getKnight().readQuest(questDetails);
    }

    public Double getArmor() {
        return getKnight().getArmor();
    }

    public void reduceArmor(Double reduceValue) {
        getKnight().reduceArmor(reduceValue);
    }

    public KnightWeapon getWeapon() {
        return getKnight().getWeapon();
    }

    public void setWeapon(KnightWeapon knightWeapon) {
        getKnight().setWeapon(knightWeapon);
    }

}
