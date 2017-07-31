import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by saurabhkumar on 31/07/17.
 */
public class G_SetKthBitTest {
	@Test
	public void testSetKthBit() throws Exception {
		/*
		Input : n = 10, k = 2
		Output : 14
		(10)_10 = (1010)_2
		Now, set the 2nd bit from right.
		(14)10 = (1110)_2
		2nd bit has been set.
		 */
		assertEquals(G_SetKthBit.setKthBit(10, 2), 14);
	}

	@Test
	public void testSetKthBit2() throws Exception {
		/*
		Input : n = 15, k = 3
		Output : 15
		3rd bit of 15 is already set.
		 */
		assertEquals(G_SetKthBit.setKthBit(15, 3), 15);
	}

}