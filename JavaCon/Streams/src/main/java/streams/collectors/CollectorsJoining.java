/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.collectors;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by saurabhkumar on 12/02/17.
 */

interface UtilProcessors {
	//static method inside interface
	static int getProcessorCores() {
		return Runtime.getRuntime().availableProcessors();
	}
}

public class CollectorsJoining {

	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Ram", "Shyam", "Sita", "Gita");

		System.out.println(
				nameList.stream()
						.map(String::toUpperCase)
						.collect(joining(", ")));

		/*
		 * joining()
		 *
		 * Returns a {@code Collector} that concatenates the input elements,
		 * separated by the specified delimiter, in encounter order.
		 */

		System.out.println(UtilProcessors.getProcessorCores());
	}
}
