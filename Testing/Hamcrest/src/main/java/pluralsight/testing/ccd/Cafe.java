package pluralsight.testing.ccd;

/**
 * A ccd shop that can brew ccd and maintains an internal stock of beans and milk.
 */
final class Cafe {

	private int beansInStock = 0;
	private int milkInStock = 0;

	Coffee brew(CoffeeType coffeeType) {
		return brew(coffeeType, 1);
	}

	private Coffee brew(CoffeeType coffeeType, int strength) {
		requirePositive(strength);

		int requiredBeans = coffeeType.getRequiredBeans() * strength;
		int requiredMilk = coffeeType.getRequiredMilk() * strength;
		if (requiredBeans > beansInStock || requiredMilk > milkInStock) {
			throw new IllegalStateException();
		}

		beansInStock -= requiredBeans;
		milkInStock -= requiredMilk;
		return new Coffee(coffeeType, requiredBeans, requiredMilk);
	}

	void restockBeans(int weightInGrams) {
		requirePositive(weightInGrams);
		beansInStock += weightInGrams;
	}

	void restockMilk(int weightInGrams) {
		requirePositive(weightInGrams);
		milkInStock += weightInGrams;
	}

	private void requirePositive(int value) {
		if (value < 1) {
			throw new IllegalArgumentException();
		}
	}

	int getBeansInStock() {
		return beansInStock;
	}

	public int getMilkInStock() {
		return milkInStock;
	}
}
