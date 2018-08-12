package knightdemo.model;

public interface Knight {
    String getName();

    KnightWeapon getWeapon();

    void setWeapon(KnightWeapon knightWeapon);

    Knight cloneKnight() throws CloneNotSupportedException;

    Integer getDamage();

    void readQuest(String questDetails);

    Double getArmor();

    void reduceArmor(Double reduceValue);

}
