import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 21/07/17.
 */
public class D_CountTotalSetBitsTest {
	@Test
	public void testGetSetBitCountForNumber4() throws Exception {
		assertEquals(D_CountTotalSetBits.getSetBitCountForNumber(4), 1);
	}

	@Test
	public void testGetSetBitCountForNumber15() throws Exception {
		assertEquals(D_CountTotalSetBits.getSetBitCountForNumber(15), 4);
	}

	@Test
	public void testGetSetBitCountForNumber126() throws Exception {
		assertEquals(D_CountTotalSetBits.getSetBitCountForNumber(126), 6);
	}

	@Test
	public void testGetSetBitCountForNumber_2() throws Exception {
		assertEquals(D_CountTotalSetBits.getSetBitCountForNumber(-2), 31);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCountTotalNumberOfSetBitsTillNumber_2() throws Exception {
		assertEquals(D_CountTotalSetBits.countTotalSetBitsTillNumber(-2), 31);
	}

	@Test
	public void testCountTotalNumberOfSetBitsTillNumber4() throws Exception {
		assertEquals(D_CountTotalSetBits.countTotalSetBitsTillNumber(4), 5);
	}

	@Test
	public void testCountTotalNumberOfSetBitsTillNumber6() throws Exception {
		assertEquals(D_CountTotalSetBits.countTotalSetBitsTillNumber(17), 35);
	}

}