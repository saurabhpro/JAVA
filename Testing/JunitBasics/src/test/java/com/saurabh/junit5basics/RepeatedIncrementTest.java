package com.saurabh.junit5basics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IncrementTest {

	private static Logger logger = LoggerFactory.getLogger(IncrementTest.class);

	@BeforeEach
	void increment() {
		logger.info(() -> "Before Each Test");
	}

	@RepeatedTest(value = 3, name = RepeatedTest.SHORT_DISPLAY_NAME)
	void test(RepetitionInfo info) {
		assertTrue(1 == 1);
		logger.info(() -> "Repetition #" + info.getCurrentRepetition());
	}
}