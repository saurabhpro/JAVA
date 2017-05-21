package testing.junit.ccd;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An individual ccd that has been served.
 */
public final class Coffee {

	private final CoffeeType type;
	private final int beans;
	private final int milk;

	Coffee(CoffeeType coffeeType, int beans, int milk) {
		this.type = coffeeType;
		this.beans = beans;
		this.milk = milk;
	}

	@Contract(pure = true)
		//check that the method has no visible side effects,
		// that the method's return value is actually used in the call place.
	CoffeeType getType() {
		return type;
	}

	@Contract(pure = true)
	public int getBeans() {
		return beans;
	}

	@Contract(pure = true)
	int getMilk() {
		return milk;
	}

	@NotNull
	@Contract(pure = true)
	@Override
	public String toString() {
		return "Coffee{" +
				"type=" + type +
				", beans=" + beans +
				", milk=" + milk +
				'}';
	}
}
