/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package streams.basics;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class ReuseStreamSupplierSolution {

	public static void main(String[] args) {

		String[] array = {"a", "b", "c", "d", "e"};

		Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);

		//get new stream
		//noinspection Convert2MethodRef
		streamSupplier.get().forEach(x -> System.out.println(x));

		//get another new stream
		@SuppressWarnings("Convert2MethodRef") long count = streamSupplier.get().filter(x -> "b".equals(x)).count();
		System.out.println(count);
	}

}