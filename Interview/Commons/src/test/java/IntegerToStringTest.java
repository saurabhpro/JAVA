
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by saurabhkumar on 19/07/17.
 */
public class IntegerToStringTest {
	private IntegerToString integerToString;

	@BeforeClass
	public void prepareClassInstance() {
		//System.out.println("hey");
		integerToString = new IntegerToString();
	}

	@Test
	public void testPrintBase2Binary() throws Exception {
		System.out.print("c: ");
		integerToString.printIn(100, 2);
	}

	@Test
	public void testIntegerToBinary() {
		System.out.println("a");
		System.out.println(Integer.toBinaryString(100));
		System.out.println(Integer.toBinaryString(-40));
	}

	@Test
	public void testPrintBase4() throws Exception {
		System.out.print("d: ");
		integerToString.printIn(100, 4);
	}

	@Test
	public void testPrintBase8Octal() throws Exception {
		System.out.print("e: ");
		integerToString.printIn(100, 8);
	}

	@Test
	public void testPrintBase16Hex() throws Exception {
		System.out.print("b: ");
		integerToString.printIn(100, 16);
	}
}