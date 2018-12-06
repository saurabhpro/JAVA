/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package dynamic;

import java.util.List;
import java.util.stream.Collectors;

public class InferenceVar {
	public static void main(String[] args) {
		//var only works for local variable and foreach
		var list = List.of("ram", "sam");
		List<String> collect = list.stream()
				.map((var s) -> s.toLowerCase())
				.collect(Collectors.toList());

	}
}
