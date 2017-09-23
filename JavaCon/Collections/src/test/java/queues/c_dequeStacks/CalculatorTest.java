package queues.c_dequeStacks;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorTest {
	private Calculator calculator = new Calculator();

	@Test
	public void shouldEvaluateConstants() {
		int result = calculator.evaluate("1");
		assertEquals(1, result);
	}

	@Test
	public void shouldSupportAdding() {
		int result = calculator.evaluate("1 + 2");
		assertEquals(3, result);
	}

	@Test
	public void shouldSupportSubtraction() {
		int result = calculator.evaluate("1 - 2");
		assertEquals(-1, result);
	}

	@Test
	public void shouldComplexStatements() {
		int result = calculator.evaluate("1 - 3 + 2 + 4");
		assertEquals(4, result);
	}
}
