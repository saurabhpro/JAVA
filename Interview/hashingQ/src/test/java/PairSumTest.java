import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by saurabhkumar on 27/07/17.
 */
public class PairSumTest {
	@Test
	public void testGetPairsCount() throws Exception {
		assertEquals(PairSum.getPairsCount(new int[]{1, 5, 7, -1, 5}, 6), 3);
	}

	@Test
	public void testGetPairsCount2() throws Exception {
		assertEquals(PairSum.getPairsCount(new int[]{1, 5}, 5), 0);
	}

	@Test
	public void testGetPairsCount3() throws Exception {
		assertEquals(PairSum.getPairsCount(new int[]{1, 1, 1}, 2), 3);
	}

}