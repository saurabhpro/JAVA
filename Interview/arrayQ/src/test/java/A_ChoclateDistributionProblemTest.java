import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class A_ChoclateDistributionProblemTest {
	@Test
	void distributeThisWith5Children() {
		int[] res = A_ChoclateDistributionProblem.distribute(new int[]{3, 4, 1, 9, 56, 7, 9, 12}, 5);
		Arrays.stream(res).mapToObj(re -> re + " ").forEach(System.out::print);

		Assertions.assertArrayEquals(new int[]{3, 4, 7, 9, 9}, res);
	}

	@Test
	void distributeThisWith10Children() {
		int[] res = A_ChoclateDistributionProblem.distribute(new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50}, 7);
		Arrays.stream(res).mapToObj(re -> re + " ").forEach(System.out::print);

		int minDifference = res[res.length - 1] - res[0];
		Assertions.assertEquals(10, minDifference);
	}

	@Test
	void distributeThisWithNoChildren() {
		Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> A_ChoclateDistributionProblem.distribute(new int[]{}, 7));

		Assertions.assertEquals("Distribution unsuccessful", exception.getMessage());
	}
}