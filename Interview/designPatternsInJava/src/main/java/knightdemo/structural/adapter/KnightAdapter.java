package knightdemo.structural.adapter;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;

/**
 * @author saurabh
 *         <p>
 *         Knight adapter adapts the OldKnight and allows developers to use this class as it is knight
 */
public class KnightAdapter implements Knight, Cloneable {

	private OldKnight oldKnight = null;

	public KnightAdapter() {
		oldKnight = new OldKnight();
	}

	public String getName() {
		return oldKnight.getSirsName();
	}

	public Knight cloneKnight() throws CloneNotSupportedException {
		return (Knight) super.clone();
	}

	@Override
	public String toString() {
		return oldKnight.toString();
	}

	public Integer getDamage() {
		return 0;
	}

	public void readQuest(String questDetails) {

	}

	public Double getArmor() {
		return 0d;
	}

	public void reduceArmor(Double reduceValue) {
		// Nothing here
	}

	public KnightWeapon getWeapon() {
		return null;
	}

	public void setWeapon(KnightWeapon knightWeapon) {
		oldKnight.setSirsWeapon(knightWeapon.name());
	}

}
