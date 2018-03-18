package knightdemo.behavioral.memento;

import knightdemo.model.KnightWeapon;

/**
 * @author saurabh
 * <p>
 * Memento class used to remember the weapon state
 */
public class Memento {

	private KnightWeapon weapon = null;

	public Memento(KnightWeapon weapon) {
		super();
		this.weapon = weapon;
	}

	public KnightWeapon getWeapon() {
		return weapon;
	}
}
