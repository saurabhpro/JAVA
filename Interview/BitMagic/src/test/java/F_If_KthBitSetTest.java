import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class F_If_KthBitSetTest {
	@Test
	public void testIfKthBitIsSet() throws Exception {
		assertEquals(F_IfKthBitSet.ifKthBitIsSet(5, 1), true);
	}

}