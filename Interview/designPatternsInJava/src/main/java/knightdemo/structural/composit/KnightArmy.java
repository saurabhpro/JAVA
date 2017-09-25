package knightdemo.structural.composit;

import knightdemo.model.Knight;
import knightdemo.model.KnightWeapon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saurabh
 *         <p>
 *         Class that holds the list of knights and allows calculations and actions on all of the knights
 */
public class KnightArmy implements Knight, Cloneable {

	private List<Knight> knights = new ArrayList<>();
	private String armyName = null;

	public void addKnight(Knight knight) {
		knights.add(knight);
	}

	public String getName() {
		return armyName;
	}

	public void setName(String name) {
		this.armyName = name;
	}

	public Knight cloneKnight() throws CloneNotSupportedException {
		return (Knight) this.clone();
	}

	public Integer getDamage() {
		Integer totalDamage = 0;
		for (Knight knight : knights) {
			totalDamage += knight.getDamage();
		}

		return totalDamage;
	}

	public void readQuest(String questDetails) {
		for (Knight knight : knights) {
			knight.readQuest(questDetails);
		}
	}

	public Double getArmor() {
		Double armorTotal = 0d;
		for (Knight knight : knights) {
			armorTotal += knight.getArmor();
		}
		return armorTotal;
	}

	public void reduceArmor(Double reduceValue) {
		//reduce the armor to all knights equally
		Double perKnight = reduceValue / knights.size();
		for (Knight knight : knights) {
			knight.reduceArmor(perKnight);
		}
	}

	public KnightWeapon getWeapon() {
		return null;
	}

	public void setWeapon(KnightWeapon knightWeapon) {
		for (Knight knight : knights) {
			knight.setWeapon(knightWeapon);
		}
	}
}
