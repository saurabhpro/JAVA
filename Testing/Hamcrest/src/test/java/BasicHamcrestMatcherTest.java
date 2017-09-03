import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;


public class BasicHamcrestMatcherTest {
	@Test
	public void basicHamcrestMatcherExamplesTest() {
		//List
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100, 101));
		assertThat(scores, everyItem(greaterThan(90)));
		assertThat(scores, everyItem(lessThan(200)));

		// String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());

		// Array
		Integer[] marks = {1, 2, 3};

		assertThat(marks, arrayWithSize(3));
		assertNotEquals("All items of array not compared", marks, arrayContaining(1, 2));    //order must be same
		assertThat(marks, arrayContainingInAnyOrder(2, 3, 1));
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
	public void mapShouldContainValue() {
		Map<String, Integer> values = getValues();

		assertThat(values, Matchers.hasKey("B"));
	}

	private List<Integer> getNumbers() {
		return Arrays.asList(1, 2, 3, 5, 4);
	}

	@Test
	public void listOrderingIsIrrelevant() {
		List<Integer> numbers = getNumbers();

		assertThat(numbers, Matchers.hasItem(5));
	}
}
