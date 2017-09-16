package universe;

import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class PlateauTest {

	@Test
	public void locationWithCoordinateWithinBoundsIsIdentified() {
		//Given
		Plateau mars = new Plateau(5, 5);

		//When
		Coordinates plateauCoordinates = new Coordinates(5, 0);

		//Then
		Assert.assertTrue(mars.hasWithinBounds(plateauCoordinates));
	}

	@Test
	public void locationWithPositiveXCoordinateOutsideBoundsIsIdentified() {
		//Given
		Plateau mars = new Plateau(5, 5);

		//When
		Coordinates coordinates = new Coordinates(6, 0);

		//Then
		Assert.assertFalse(mars.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithNegativeXCoordinateOutsideBoundsIsIdentified() {
		//Given
		Plateau mars = new Plateau(5, 5);

		//When
		Coordinates coordinates = new Coordinates(-1, 0);


		//Then
		Assert.assertFalse(mars.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithPositiveYCoordinateOutsideBoundsIsIdentified() {
		//Given
		Plateau mars = new Plateau(5, 5);

		//When
		Coordinates coordinates = new Coordinates(0, 6);


		//Then
		Assert.assertFalse(mars.hasWithinBounds(coordinates));
	}

	@Test
	public void locationWithNegativeYCoordinateOutsideBoundsIsIdentified() {
		//Given
		Plateau mars = new Plateau(5, 5);

		//When
		Coordinates coordinates = new Coordinates(0, -1);


		//Then
		Assert.assertFalse(mars.hasWithinBounds(coordinates));
	}
}
