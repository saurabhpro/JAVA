package b_structural.d_decorator.sandwich;

public class DressingDecorator extends SandwichDecorator {

	public DressingDecorator(Sandwich customSandwich) {
		super(customSandwich);
	}

	public String make() {
		return customSandwich.make() + addDressing();
	}

	@SuppressWarnings("SameReturnValue")
	private String addDressing() {
		return " + mustard";
	}

}
