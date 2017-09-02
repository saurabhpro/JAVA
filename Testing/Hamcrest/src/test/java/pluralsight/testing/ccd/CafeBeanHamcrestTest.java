package pluralsight.testing.ccd;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static pluralsight.testing.ccd.CoffeeType.Espresso;
import static pluralsight.testing.ccd.CoffeeType.Latte;

public class CafeBeanHamcrestTest {

	private static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
	private static final int NO_MILK = 0;
	private static final int NO_BEANS = 0;

	private Cafe cafe;

	@Before
	public void before() {
		cafe = new Cafe();
	}

	private void withBeans() {
		cafe.restockBeans(ESPRESSO_BEANS);
	}

	@Test
	public void coffeeHasBeansProperty() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		//then
		assertThat(coffee, hasProperty("beans"));
	}

	@Test
	public void coffeeHasCorrectBeansValue() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		//then
		assertThat(coffee, hasProperty("beans", equalTo(ESPRESSO_BEANS)));
	}

	@Test
	public void bothCoffeesHaveSameProperty() {
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
	public void canBrewEspresso() {
		// given
		withBeans();

		// when
		Coffee coffee = cafe.brew(Espresso);

		// then
		assertThat(coffee, hasProperty("beans"));
		assertThat(coffee, hasProperty("beans", Matchers.equalTo(ESPRESSO_BEANS)));

		assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
		assertEquals("Wrong coffee type", Espresso, coffee.getType());
	}

	@Test
	public void brewingEspressoConsumesBeans() {
		// given
		withBeans();

		// when
		cafe.brew(Espresso);

		// then
		assertEquals(NO_BEANS, cafe.getBeansInStock());
	}

	@Test
	public void canBrewLatte() {
		// given
		withBeans();
		cafe.restockMilk(Latte.getRequiredMilk());

		// when
		Coffee coffee = cafe.brew(Latte);

		// then
		assertEquals("Wrong coffee type", Latte, coffee.getType());
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockMilk() {
		// when
		cafe.restockMilk(NO_MILK);
	}

	@Test(expected = IllegalArgumentException.class)
	public void mustRestockBeans() {
		// when
		cafe.restockBeans(NO_BEANS);
	}

	@Test(expected = IllegalStateException.class)
	public void lattesRequireMilk() {
		// given
		withBeans();

		// when
		cafe.brew(Latte);
	}
}
