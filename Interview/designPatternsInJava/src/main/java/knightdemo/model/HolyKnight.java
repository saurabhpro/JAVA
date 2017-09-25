package knightdemo.model;

/**
 * @author saurabh
 */
public class HolyKnight extends AbstractKnight {

	public String getName() {
		return "Holy Knight is my name!";
	}

	@Override
	public String toString() {
		return "HolyKnight [getName()=" + getName() + ", getWeapon()=" + getWeapon() + "]";
	}

	@Override
	public Integer getDamage() {
		return super.getDamage() * 2;
	}

}
