import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class C_PeekElementTest {

	@Nested
	@DisplayName("Test simple method")
			//static class is not tested by @Nested
	class Test1 {
		@Test
		void giveFirstPeekNumber() {

			Assertions.assertEquals(20, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{5, 10, 20, 15}));
		}

		@Test
		void giveFirstPeekNumber2() {

			Assertions.assertEquals(50, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{10, 20, 30, 40, 50}));
		}


		@Test
		void giveFirstPeekNumber3() {

			Assertions.assertEquals(100, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{100, 80, 60, 50, 20}));
		}

		@Test
		void giveFirstPeekNumber4() {

			Assertions.assertEquals(20, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{10, 20, 15, 16, 23, 90, 67}));
		}

		@Test
		void giveFirstPeekNumber5() {

			Assertions.assertEquals(20, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{1, 3, 20, 4, 1, 0}));
		}

		@Test
		void giveFirstPeekNumber6() {

			Assertions.assertEquals(4, C_PeekElement.giveFirstPeekNumberByClevererIdea(new int[]{4, 4, 4, 4, 4, 4}));
		}

	}

	@Nested
	@DisplayName("Test binary search method")
	class Test2 {
		@Test
		void givePeekNumber() {

			Assertions.assertEquals(20, C_PeekElement.findPeak(new int[]{5, 10, 20, 15}));
		}

		@Test
		void givePeekNumber2() {

			Assertions.assertEquals(50, C_PeekElement.findPeak(new int[]{10, 20, 30, 40, 50}));
		}


		@Test
		void givePeekNumber3() {

			Assertions.assertEquals(100, C_PeekElement.findPeak(new int[]{100, 80, 60, 50, 20}));
		}

		@Test
		void givePeekNumber4() {

			Assertions.assertEquals(90, C_PeekElement.findPeak(new int[]{10, 20, 15, 16, 23, 90, 67}));
		}

		@Test
		void givePeekNumber5() {

			Assertions.assertEquals(20, C_PeekElement.findPeak(new int[]{1, 3, 20, 4, 1, 0}));
		}

		@Test
		void givePeekNumber6() {

			Assertions.assertEquals(4, C_PeekElement.findPeak(new int[]{4, 4, 4, 4, 4, 4}));
		}
	}
}