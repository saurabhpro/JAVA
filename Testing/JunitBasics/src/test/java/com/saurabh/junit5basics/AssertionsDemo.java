package com.saurabh.junit5basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AssertionsDemo {

	private Person person = new Person();

	private static String greeting() {
		return "hello world!";
	}

	@Test
	void standardAssertions() {
		assertEquals(2, 2);
		assertEquals(4, 4, "The optional assertion message is now the last parameter.");
		assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- "
				+ "to avoid constructing complex messages unnecessarily.");
	}

	@Test
	void groupedAssertions() {
		// In a grouped assertion all assertions are executed, and any
		// failures will be reported together.
		assertAll("person",
				() -> assertEquals("saurabh", person.getFirstName()),
				() -> assertEquals("kumar", person.getLastName())
		);
	}

	@Test
	void dependentAssertions() {
		// Within a code block, if an assertion fails the
		// subsequent code in the same block will be skipped.
		assertAll("properties",
				() -> {
					String firstName = person.getFirstName();
					assertNotNull(firstName);

					// Executed only if the previous assertion is valid.
					assertAll("first name",
							() -> assertTrue(firstName.startsWith("s")),
							() -> assertTrue(firstName.endsWith("h"))
					);
				},
				() -> {
					// Grouped assertion, so processed independently
					// of results of first name assertions.
					String lastName = person.getLastName();
					assertNotNull(lastName);

					// Executed only if the previous assertion is valid.
					assertAll("last name",
							() -> assertTrue(lastName.startsWith("k")),
							() -> assertTrue(lastName.endsWith("r"))
					);
				}
		);
	}

	@Test
	void exceptionTesting() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			throw new IllegalArgumentException("a message");
		});
		assertEquals("a message", exception.getMessage());
	}

	@Test
	void timeoutNotExceeded() {
		// The following assertion succeeds.
		assertTimeout(ofMinutes(2), () -> {
			// Perform task that takes less than 2 minutes.
		});
	}

	@Test
	void timeoutNotExceededWithResult() {
		// The following assertion succeeds, and returns the supplied object.
		String actualResult = assertTimeout(ofMinutes(2), () -> {
			return "a result";
		});
		assertEquals("a result", actualResult);
	}

	@Test
	void timeoutNotExceededWithMethod() {
		// The following assertion invokes a method reference and returns an object.
		String actualGreeting = assertTimeout(ofMinutes(2), AssertionsDemo::greeting);
		assertEquals("hello world!", actualGreeting);
	}

	@Test
	void timeoutExceeded() {
		// The following assertion fails with an error message similar to:
		// execution exceeded timeout of 10 ms by 91 ms
		assertTimeout(ofMillis(10), () -> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(100);
		});
	}

	@Test
	void timeoutExceededWithPreemptiveTermination() {
		// The following assertion fails with an error message similar to:
		// execution timed out after 10 ms
		assertTimeoutPreemptively(ofMillis(10), () -> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(100);
		});
	}

	@Test
	void testOnlyOnCiServer() {
		assumeTrue("CI".equals(System.getenv("ENV")));
		// remainder of test
	}

	@Test
	void testOnlyOnDeveloperWorkstation() {
		assumeTrue("DEV".equals(System.getenv("ENV")),
				() -> "Aborting test: not on developer workstation");
		// remainder of test
	}

	@Test
	void testInAllEnvironments() {
		assumingThat("CI".equals(System.getenv("ENV")),
				() -> {
					// perform these assertions only on the CI server
					assertEquals(2, 2);
				});

		// perform these assertions in all environments
		assertEquals("a string", "a string");
	}

	@Test
	void testInMacEnvironment() {
		boolean assumedResult = "mac os x".equals(System.getProperty("os.name").toLowerCase());

		assumeTrue(assumedResult);  // breaks here if its assumedResult = false
		// then write your assertions

		//OR

		// you can also do both things at once
		assumingThat(assumedResult, () -> {
			// perform these assertions only on the Mac OS
			assertEquals(2, 2);
		});
	}


	@Test
	void arrayTest() {

		Integer a = null;
		Assertions.assertNotNull(a /*returned_obj_to_check*/);    //and assertNull(...)

		Boolean b = true;
		Assertions.assertTrue(b /*should_be_true*/);  //and assertFalse(...)

		Integer c = a;
		Assertions.assertSame(a /*reference_1_of_obj*/, c /*refrence_2_of_obj*/);   //and assertNotSame(...)

		Assertions.assertThrows(NumberFormatException.class /*Expected_Exception.class*/, () -> {
		} /*method_execution_that_should_throwException*/);

		Assertions.assertTimeout(Duration.ofMillis(100) /*duration_to_wait in millis)*/, () -> {
		} /*method_execution_that_should_be_over_by_the_said_duration*/);

		Assertions.assertTimeoutPreemptively(Duration.ofMillis(100) /*duration_to_wait in millis)*/, () -> {
		} /*method_execution_that_should_be_over_by_the_said_duration*/);
		//execution of the method will be preemptively aborted if the timeout is exceeded


		int[] d = {1, 3, 4};
		int[] e = {4, 5, 6};
		Assertions.assertArrayEquals(d, e); // fails
		//simple right - it matches content in order, so even {3, 1, 4} will fail
	}

}