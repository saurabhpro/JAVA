import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


class BasicHamcrestMatcherTest {

	@Test
	void basicHamcrestMatcherExamplesTest() {
		//List
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		MatcherAssert.assertThat(scores, Matchers.hasSize(4));
		MatcherAssert.assertThat(scores, Matchers.hasItems(100, 101));
		MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.greaterThan(90)));
		MatcherAssert.assertThat(scores, Matchers.everyItem(Matchers.lessThan(200)));

		// String
		MatcherAssert.assertThat("", Matchers.isEmptyString());
		MatcherAssert.assertThat(null, Matchers.isEmptyOrNullString());

		// Array
		Integer[] marks = {1, 2, 3};

		MatcherAssert.assertThat(marks, Matchers.arrayWithSize(3));
		assertNotEquals(marks, Matchers.arrayContaining(1, 2), "All items of array not compared");    //order must be same
		MatcherAssert.assertThat(marks, Matchers.arrayContainingInAnyOrder(2, 3, 1));
	}


	/*
	Merged Pluralsight testing tutorials about hamcrest
	 */
	private Map<String, Integer> getValues() {
		final HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);

		return map;
	}

	@Test
	void mapShouldContainValue() {
		Map<String, Integer> values = getValues();

		MatcherAssert.assertThat(values, Matchers.hasKey("B"));
	}

	private List<Integer> getNumbers() {
		return Arrays.asList(1, 2, 3, 5, 4);
	}

	@Test
	void listOrderingIsIrrelevant() {
		List<Integer> numbers = getNumbers();

		MatcherAssert.assertThat(numbers, Matchers.hasItem(5));
	}
}
