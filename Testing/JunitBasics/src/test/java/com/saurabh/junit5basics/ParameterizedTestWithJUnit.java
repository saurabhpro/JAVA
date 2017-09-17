package com.saurabh.junit5basics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class ParameterizedTestWithJUnit {


	@ParameterizedTest
	@ValueSource(strings = {"Hello", "World"})
	void testWithStringParameter(String argument) {
		assertNotNull(argument);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void testWithValueSource(int argument) {
		assertNotNull(argument);
	}


	/*
	@EnumSource provides a convenient way to use Enum constants. The annotation provides an optional names parameter
	that lets you specify which constants shall be used.
	If omitted, all constants will be used like in the following example.
	 */

	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithEnumSource(TimeUnit timeUnit) {
		assertNotNull(timeUnit);
	}

	/*
	 * The @EnumSource annotation also provides an optional mode parameter that enables fine-grained control
	 * over which constants are passed to the test method. For example, you can exclude names from the enum
	 * constant pool or specify regular expressions as in the following examples.
	 */

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = {"DAYS", "HOURS"})
	void testWithEnumSourceExclude(TimeUnit timeUnit) {
		assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
		assertTrue(timeUnit.name().length() > 5);
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS"})
	void testWithEnumSourceInclude(TimeUnit timeUnit) {
		assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
	}


	/*
	@CsvSource allows you to express argument lists as comma-separated values (i.e., String literals).
	 */

	@ParameterizedTest
	@CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
	void testWithCsvSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}

	@Disabled
	@ParameterizedTest
	@CsvFileSource(resources = "/two-column.csv")
	void testWithCsvFileSource(String first, int second) {
		assertNotNull(first);
		assertNotEquals(0, second);
	}

	@ParameterizedTest
	@ValueSource(strings = "SECONDS")
	void testWithImplicitArgumentConversion(TimeUnit argument) {
		assertNotNull(argument.name());
	}

	@DisplayName("Display name of container")
	@ParameterizedTest(name = "{index} ==> first=''{0}'', second={1}")
	@CsvSource({"foo, 1", "bar, 2", "'baz, qux', 3"})
	void testWithCustomDisplayNames(String first, int second) {
	}
}
