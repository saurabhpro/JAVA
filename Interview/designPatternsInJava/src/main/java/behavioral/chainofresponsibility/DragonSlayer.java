package behavioral.chainofresponsibility;

import model.Knight;

public interface DragonSlayer {

	Knight getKnight();

	Integer getDamage();

	/**
	 * Attack the dragon at once and return if quest was successful
	 *
	 * @param minDamage
	 * @return
	 */
	Boolean attack(Integer minDamage);

}
