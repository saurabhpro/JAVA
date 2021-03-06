package pluralsight.testing.ccd;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pluralsight.testing.ccd.CoffeeType.Espresso;
import static pluralsight.testing.ccd.CoffeeType.Latte;

public class CafeBeanHamcrestJunit5Test {

	private static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
	private static final int NO_MILK = 0;
	private static final int NO_BEANS = 0;

	private Cafe cafe;

	@BeforeEach
	void before() {
		cafe = new Cafe();
	}

	private void withBeans() {
		cafe.restockBeans(ESPRESSO_BEANS);
	}

	@Test
	void coffeeHasBeansProperty() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		//then
		assertThat(coffee, hasProperty("beans"));
	}

	@Test
	void coffeeHasCorrectBeansValue() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		//then
		assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
	}

	@Test
	void bothCoffeesHaveSameProperty() {
		// given
		withBeans();

		// when
		Coffee coffee1 = cafe.brew(Espresso);

		cafe.restockBeans(7);
		Coffee coffee2 = cafe.brew(Espresso);

		//then
		assertThat(coffee1, samePropertyValuesAs(coffee2));
	}

	@Test
	void canBrewEspresso() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		// then
		assertThat(coffee, hasProperty("beans"));
		assertThat(coffee, hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));

		assertEquals(NO_MILK, coffee.getMilk(), "Wrong amount of milk");
		assertEquals(Espresso, coffee.getType(), "Wrong coffee type");
	}

	@Test
	void brewingEspressoConsumesBeans() {
		// given
		withBeans();

		// when
		cafe.brew(Espresso);

		// then
		assertEquals(NO_BEANS, cafe.getBeansInStock());
	}

	@Test
	void canBrewLatte() {
		// given
		withBeans();
		cafe.restockMilk(Latte.getRequiredMilk());

		// when
		Coffee coffee = cafe.brew(Latte);

		// then
		assertEquals(Latte, coffee.getType(), "Wrong coffee type");
	}

	@Test
	void mustRestockMilk() {
		// when
		assertThrows(IllegalArgumentException.class, () -> cafe.restockMilk(NO_MILK));
	}

	@Test
	void mustRestockBeans() {
		// when
		assertThrows(IllegalArgumentException.class, () -> cafe.restockBeans(NO_BEANS));
	}

	@Test
	void lattesRequireMilk() {
		// given
		withBeans();

		// when
		assertThrows(IllegalStateException.class, () -> cafe.brew(Latte));
	}
}
