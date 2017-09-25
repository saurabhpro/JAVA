package knightdemo.creational.factorymethod;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;

/**
 * @author saurabh
 */
public interface Factory {

	Knight createKnight(KnightWeapon weapon);
}
