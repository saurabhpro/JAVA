import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class B_SubArrayWithGivenSumUnSortedTest {

	private B_SubArrayWithGivenSumUnSorted obj;

	@BeforeEach
	void setUp() {
		obj = new B_SubArrayWithGivenSumUnSorted();
	}

	@Test
	void sumSubArray() {
		Assertions.assertArrayEquals(new int[]{7, 5}, obj.sumSubArray(new int[]{1, 2, 3, 7, 5}, 12));

	}

}