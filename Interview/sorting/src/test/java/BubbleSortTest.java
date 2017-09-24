import org.junit.jupiter.api.Test;


/**
 * Created by saurabhkumar on 09/09/17.
 */
public class BubbleSortTest {
	@Test
	public void testSort() throws Exception {
		BubbleSort algorithm = new BubbleSort();

		int[] sortedAlgo = algorithm.sort(new int[] { 8, 1, 3, 4, 6 });
		int[] expectd = new int[]{8, 6, 4, 3, 1};
		//Assert.assertThat(sortedAlgo, is(arrayContaining(expectd)));

		//print("final", ));
	}

}