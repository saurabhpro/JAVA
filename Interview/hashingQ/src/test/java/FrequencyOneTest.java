import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by saurabhkumar on 26/07/17.
 */
public class FrequencyOneTest {
	@Test
	public void testOnlyOneRepeatedChar() throws Exception {
		assertTrue(FrequencyOne.ifFrequencyCanBeEqualizedbyRemovingAtMostOneChar("abbc"));
	}

	@Test
	public void testOnlyOneRepeatedChar1() throws Exception {
		assertFalse(FrequencyOne.ifFrequencyCanBeEqualizedbyRemovingAtMostOneChar("aabbcccc"));
	}


	@Test
	public void testOnlyOneRepeatedChar2() throws Exception {
		assertTrue(FrequencyOne.ifFrequencyCanBeEqualizedbyRemovingAtMostOneChar("abbb"));
	}

	@Test
	public void testOnlyOneRepeatedChar3() throws Exception {
		assertFalse(FrequencyOne.ifFrequencyCanBeEqualizedbyRemovingAtMostOneChar("aabbcd"));
	}
}