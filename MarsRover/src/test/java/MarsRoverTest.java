import com.thoughtworks.rover.MarsRover;
import com.thoughtworks.rover.universe.Coordinates;
import com.thoughtworks.rover.universe.Direction;
import com.thoughtworks.rover.universe.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

	@Test
	public void canProvideCurrentLocationAsString() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(3, 3);

		//When
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//then
		Assert.assertEquals("Coordinates{xCoordinate=3, yCoordinate=3} N", marsRover.currentLocation());
	}

	@Test
	public void canRotateLeft() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.turnLeft();

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=2} W", marsRover.currentLocation());
	}

	@Test
	public void canRotateRight() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.turnRight();

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=2} E", marsRover.currentLocation());
	}

	@Test
	public void canMove() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.move();

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=3} N", marsRover.currentLocation());
	}

	@Test
	public void canRunCommandToRotateRight() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.run("R");

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=2} E", marsRover.currentLocation());
	}

	@Test
	public void canRunCommandToRotateLeft() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.run("L");

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=2} W", marsRover.currentLocation());
	}

	@Test
	public void canRunCommandToMove() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(1, 2);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.run("M");

		//then
		Assert.assertEquals("Coordinates{xCoordinate=1, yCoordinate=3} N", marsRover.currentLocation());
	}

	@Test
	public void canRunCommandWithMultipleInstructions() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(3, 3);
		MarsRover marsRover = new MarsRover(plateau, Direction.E, startingPosition);

		//When
		marsRover.run("MMRMMRMRRM");

		//then
		Assert.assertEquals("Coordinates{xCoordinate=5, yCoordinate=1} E", marsRover.currentLocation());
	}

	@Test
	public void wontDriveOffPlateau() {
		//Given
		Plateau plateau = new Plateau(5, 5);
		Coordinates startingPosition = new Coordinates(3, 3);
		MarsRover marsRover = new MarsRover(plateau, Direction.N, startingPosition);

		//When
		marsRover.run("MMMMMMMMMMR");

		//then
		Assert.assertEquals("Coordinates{xCoordinate=3, yCoordinate=5} E", marsRover.currentLocation());
	}
}
