import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by saurabhkumar on 27/07/17.
 */
public class SwapToMakeArraySumEqualTest {
    @Test
    public void testIsPairExist() throws Exception {
        assertEquals(SwapToMakeArraySumEqual.ifPairExistNaiveApproach(new int[]{4, 1, 2, 1, 1, 2}, new int[]{3, 6, 3, 3}), true);
    }

    @Test
    public void testIsPairExist2() throws Exception {
        assertEquals(SwapToMakeArraySumEqual.ifPairExistNaiveApproach(new int[]{5, 7, 4, 6}, new int[]{1, 2, 3, 8}), true);
    }

    @Test
    public void testIsPairExist3() throws Exception {
        assertEquals(SwapToMakeArraySumEqual.ifPairExistNaiveApproach(new int[]{4, 1, 2}, new int[]{3, 2, 4}), true);
    }

}