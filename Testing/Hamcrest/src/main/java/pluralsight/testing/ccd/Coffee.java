package pluralsight.testing.ccd;

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

	//check that the method has no visible side effects,
	// that the method's return value is actually used in the call place.
	CoffeeType getType() {
		return type;
	}

	public int getBeans() {
		return beans;
	}

	int getMilk() {
		return milk;
	}

	@Override
	public String toString() {
		return "Coffee{" +
				"type=" + type +
				", beans=" + beans +
				", milk=" + milk +
				'}';
	}
}
