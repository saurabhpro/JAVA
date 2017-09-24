import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by saurabhkumar on 23/07/17.
 */
public class RomanToDecimalTest {
	@Test
	public void testValidateRomanNumber() throws Exception {
		assertTrue(RomanToDecimal.validateRomanNumber("XV"));
		assertTrue(RomanToDecimal.validateRomanNumber("XL"));
	}

	@Test
	public void testIntegerValueForRomanCharacter() throws Exception {
		assertEquals(RomanToDecimal.integerValueForRomanCharacter('V'), 5);
		assertEquals(RomanToDecimal.integerValueForRomanCharacter('I'), 1);
		assertEquals(RomanToDecimal.integerValueForRomanCharacter('C'), 100);
		assertEquals(RomanToDecimal.integerValueForRomanCharacter('M'), 1000);
		assertEquals(RomanToDecimal.integerValueForRomanCharacter('D'), 500);
	}

	@Test
	public void testRomanToDecimal() throws Exception {
		assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
		//assertEquals(RomanToDecimal.romanToDecimal("IDX"), 9);
	}

}