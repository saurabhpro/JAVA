/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package java9;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java9Optional {

	public static void main(String[] args) {

		System.out.println("--- stream() ---");
		// throw java.util.NoSuchElementException
		// List<String> strings = getStreamOptional().map(Optional::get).collect(Collectors.toList());

		List<String> strings = getStreamOptional()
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());

		System.out.println(strings);

		List<String> newStrings = getStreamOptional()
				.flatMap(Optional::stream)
				.collect(Collectors.toList());

		System.out.println(newStrings);

		System.out.println("\n--- ifPresent()/isPresent()/orElse() ---");
		Optional<Integer> result1 = Optional.of(42);
		result1.ifPresent(x -> System.out.println("Result = " + x));

		Optional<Integer> result2 = Optional.empty();
		result2.ifPresent(x -> System.out.println("Result = " + x));

		//noinspection ConstantConditions
		if (result2.isPresent())
			System.out.println("Result = " + result2.get());
		else
			System.out.println("return " + result2.orElse(-1) + ": Result not found.");

		System.out.println("\n--- ifPresentOrElse() ---");
		Optional<Integer> result3 = getOptionalEmpty();
		result3.ifPresentOrElse(x -> System.out.println("Result = " + x),
				() -> System.out.println("return " + result2.orElse(-1) + ": Result not found."));

		System.out.println("\n--- or() ---");
		//noinspection Convert2MethodRef
		Optional<Integer> result = getOptionalEmpty()
				.or(() -> getAnotherOptionalEmpty())
				.or(() -> getOptionalNormal())
				.or(() -> getAnotherOptionalNormal());
		System.out.println(result);
	}

	private static Optional<Integer> getOptionalNormal() {
		return Optional.of(42);
	}

	private static Optional<Integer> getAnotherOptionalNormal() {
		return Optional.of(99);
	}

	private static Optional<Integer> getOptionalEmpty() {
		return Optional.empty();
	}

	private static Optional<Integer> getAnotherOptionalEmpty() {
		return Optional.empty();
	}

	private static Stream<Optional<String>> getStreamOptional() {

		return Stream.of(Optional.empty(), Optional.of("one"), Optional.of("two"), Optional.of("three"));
	}
}