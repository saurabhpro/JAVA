package com.saurabh.junit5basics;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;


class StandardTests {
	@BeforeAll
	static void initAll() {
	}

	@AfterAll
	static void tearDown() {
	}

	@BeforeEach
	void tearDownAll() {
	}

	@Test
	void init() {
	}

	/*
	JUnit Jupiter provides the ability to repeat a test a specified number of times simply by annotating
	a method with @RepeatedTest and specifying the total number of repetitions desired.

	Each invocation of a repeated test behaves like the execution of a regular @Test method with full support
	for the same lifecycle callbacks and extensions.
	 */
	@RepeatedTest(10)
	//or simply @Test
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
}