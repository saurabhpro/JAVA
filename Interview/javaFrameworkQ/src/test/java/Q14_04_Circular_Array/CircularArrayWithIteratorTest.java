package Q14_04_Circular_Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularArrayWithIteratorTest {
	private final int size = 10;
	private CircularArrayWithIterator<String> array;

	@BeforeEach
	void setUp() {
		array = new CircularArrayWithIterator<>(size);
		for (int i = 0; i < size; i++) {
			array.setItem(i, String.valueOf(i));
		}
	}

	@Test
	void firstTestOfDisp() {
		System.out.println("\nOriginal:");
		for (String s : array) {
			System.out.print(s + " ");
		}
	}

	@Test
	void shiftByPositive3() {
		System.out.println("\nOriginal by 3");

		array.rotate(3);
		for (int i = 0; i < size; i++) {
			System.out.print(array.getItem(i) + " ");
		}
	}

	@Test
	void shiftByNegative2() {
		System.out.println("\nOriginal by -2");

		array.rotate(-2);
		for (String s : array) {
			System.out.print(s + " ");
		}

		//Assertions.assertArrayEquals(new String[1 2 3 4 5 6 7 8 9 0]);
	}
}