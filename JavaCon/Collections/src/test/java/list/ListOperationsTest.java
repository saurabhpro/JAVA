/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ListOperationsTest {

	@Test
	void unmodifiableTest() {
		List<String> modifiable = new ArrayList<>();
		modifiable.add("1");

		List<String> unmodifiable = Collections.unmodifiableList(modifiable);

		assertEquals(modifiable.size(), unmodifiable.size(), "should have the same size");

		modifiable.add("2");

		assertEquals(modifiable.size(), unmodifiable.size(), "should still have the same size");

		try {
			unmodifiable.add("3");
			fail("should not succeed");
		} catch (UnsupportedOperationException ex) {
			assertTrue(true, "should throw exception");
		}

		assertEquals(modifiable.size(), unmodifiable.size(), "should still have the same size");
	}

	@Test
	void immutableTest() {
		List<String> modifiable = new ArrayList<>();
		modifiable.add("1");

		//List<String> immutable = Collections.unmodifiableList(new ArrayList<String>(modifiable));
		//java11
		List<String> immutable = List.copyOf(modifiable);

		assertEquals(modifiable.size(), immutable.size(), "should have the same size");

		modifiable.add("2");

		assertTrue(modifiable.size() != immutable.size(), "should no longer have the same size");

		try {
			immutable.add("3");
			fail("should not succeed");
		} catch (UnsupportedOperationException ex) {
			assertTrue(true, "should throw exception");
		}
	}

	@Test
	void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		List<String> immutableList = List.of("Tew");

		Assertions.assertThrows(UnsupportedOperationException.class, () -> immutableList.add("four"));
	}

	@Test
	void testList() {

		List<String> modifiableList = new ArrayList<>();
		modifiableList.add("a");

		System.out.println("modifiableList:" + modifiableList);
		System.out.println("--");


		//unModifiableList

		assertEquals(1, modifiableList.size());

		List<String> unModifiableList = Collections.unmodifiableList(modifiableList);

		modifiableList.add("b");    // it also updates the opject thats based on it - unmodifiable object

		Assertions.assertEquals(2, unModifiableList.size(), "How did unmodifiable become 2");

		boolean exceptionThrown = false;
		try {
			unModifiableList.add("b");
			fail("add supported for unModifiableList!!");

		} catch (UnsupportedOperationException e) {
			exceptionThrown = true;
			System.out.println("unModifiableList.add() not supported");
		}
		assertTrue(exceptionThrown);

		System.out.println("modifiableList:" + modifiableList);
		System.out.println("unModifiableList:" + unModifiableList);

		assertEquals(2, modifiableList.size());
		assertEquals(2, unModifiableList.size());
		System.out.println("--");


		//immutableList


		List<String> immutableList = List.copyOf(modifiableList);

		modifiableList.add("c");

		assertEquals(2, immutableList.size(), "This is good - size doesn't change");

		exceptionThrown = false;
		try {
			immutableList.add("c");
			fail("add supported for immutableList!!");
		} catch (UnsupportedOperationException e) {
			exceptionThrown = true;
			System.out.println("immutableList.add() not supported");
		}
		assertTrue(exceptionThrown);


		System.out.println("modifiableList:" + modifiableList);
		System.out.println("unModifiableList:" + unModifiableList);
		System.out.println("immutableList:" + immutableList);
		System.out.println("--");

		/*
		output of last three list entries after addition of 'c' to the list while both size of modifiableList
		and unModifiableList has increased, immutableList size has not changed
		 */
		assertEquals(3, modifiableList.size());
		assertEquals(3, unModifiableList.size());
		assertEquals(2, immutableList.size());

	}

}