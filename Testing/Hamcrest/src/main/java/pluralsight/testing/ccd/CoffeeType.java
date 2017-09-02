package pluralsight.testing.ccd;

/**
 * Describes the type of ccd that we're going to serve.
 */
public enum CoffeeType {
	Espresso(7, 0), Latte(7, 227), FilterCoffee(10, 0);

	private final int requiredBeans;
	private final int requiredMilk;

	CoffeeType(int requiredBeans, int requiredMilk) {
		this.requiredBeans = requiredBeans;
		this.requiredMilk = requiredMilk;
	}

	public int getRequiredBeans() {
		return requiredBeans;
	}

	public int getRequiredMilk() {
		return requiredMilk;
	}
}
