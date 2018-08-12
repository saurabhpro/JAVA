package knightdemo.model;

/**
 * @author saurabh
 */
public class MajesticKnight extends AbstractKnight {

    public String getName() {
        return "Majestic is my fathers name and so is mine!";
    }

    @Override
    public String toString() {
        return "MajesticKnight [getName()=" + getName() + ", getWeapon()=" + getWeapon() + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Integer getDamage() {
        return super.getDamage() * 3;
    }

}
