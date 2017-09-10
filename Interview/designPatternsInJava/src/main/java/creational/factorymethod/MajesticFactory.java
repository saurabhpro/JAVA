package creational.factorymethod;

import model.Knight;
import model.KnightWeapon;
import model.MajesticKnight;

/**
 * @author saurabh
 */
public class MajesticFactory implements Factory {

	public Knight createKnight(KnightWeapon weapon) {
		Knight knight = new MajesticKnight();
		knight.setWeapon(weapon);
		return knight;
	}
}
