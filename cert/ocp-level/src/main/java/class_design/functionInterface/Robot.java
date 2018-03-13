package class_design.functionInterface;

interface Pump {
	void pump(double psi);
}

interface Bend extends Pump {
	void bend(double tensileStrength);
}

public class Robot {
	// cannot use Bend as non-functional
	public static final void apply(Pump instruction, double input) { // r1
		instruction.pump(input);
	}

	public static void main(String... future) {
		final Robot r = new Robot();
		r.apply(x -> System.out.print(x + " bent!"), 5);
	}
}