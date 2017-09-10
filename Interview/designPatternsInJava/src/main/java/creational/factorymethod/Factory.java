package creational.factorymethod;

import model.Knight;
import model.KnightWeapon;

/**
 * @author saurabh
 */
public interface Factory {

	Knight createKnight(KnightWeapon weapon);
}
