package b_structural.d_decorator.sandwich;

public class MeatDecorator extends SandwichDecorator {

	public MeatDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	public String make() {
		return customSandwich.make() + addMeat();
	}

	private String addMeat() {
		return " + turkey";
	}
}
