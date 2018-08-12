import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by saurabhkumar on 28/07/17.
 */
public class MinimumCoinTest {
    @Test
    public void testMinCoins() throws Exception {
		/*
		Input: coins[] = {25, 10, 5}, V = 30
		Output: Minimum 2 coins required
		We can use one coin of 25 cents and one of 5 cents
		 */

        assertEquals(MinimumCoin.minCoins(new int[]{25, 15, 5}, 30), 2);

        /*



         */
    }

    @Test
    public void testMinCoinsDyn() throws Exception {
        assertEquals(MinimumCoin.minCoinsDyn(new int[]{25, 15, 5}, 30), 2);
    }

}