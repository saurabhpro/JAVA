package knightdemo.creational.factorymethod;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;
import knightdemo.model.MajesticKnight;

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
