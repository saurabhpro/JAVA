package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

class ConsumerUse {
	public static void main(String[] args) {
		Stream<String> strings = Stream.of("hello", "world");
		Consumer<String> printString = System.out::println;

		printString.andThen(s -> System.out.println(" SAURABH "));

		//printString.accept(s -> System.out.println(" HELLO "));
		strings.forEach(printString);


		BiConsumer<List<Integer>, Integer> listAddElement = List::add;
		List<Integer> aList = new ArrayList<>();
		listAddElement.accept(aList, 10);
		System.out.println(aList);
	}
}
