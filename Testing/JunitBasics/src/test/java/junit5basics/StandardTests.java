package junit5basics;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;


class StandardTests {
	@BeforeAll
	static void initAll() {
	}

	@BeforeEach
	static void tearDownAll() {
	}

	@Test
	void init() {
	}

	@Test
	void succeedingTest() {
	}

	@Test
	@Disabled("for demonstration purposes")
	void failingTest() {
		fail("a failing test");
	}

	@AfterEach
	void skippedTest() {
		// not executed
	}

	@AfterAll
	void tearDown() {
	}
}