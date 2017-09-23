package b_structural.d_decorator.sandwich;

public abstract class SandwichDecorator implements Sandwich {

	final Sandwich customSandwich;

	SandwichDecorator(Sandwich customSandwich) {
		this.customSandwich = customSandwich;
	}

	public String make() {
		return customSandwich.make();
	}

}
