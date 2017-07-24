import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by saurabhkumar on 20/07/17.
 */
public class B_IfPowerOfTwoTest {
	@Test
	public void testSimpleIsPowerOfTwo1() throws Exception {
	}

	@Test
	public void testSimpleIsPowerOfTwo() throws Exception {
		assertTrue(B_IfPowerOfTwo.simpleIsPowerOfTwo(32));
		assertFalse(B_IfPowerOfTwo.simpleIsPowerOfTwo(7));
	}

}