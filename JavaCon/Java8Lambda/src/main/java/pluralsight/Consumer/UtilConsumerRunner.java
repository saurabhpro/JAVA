package pluralsight.Consumer;

import java.util.function.BiConsumer;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class UtilConsumerRunner {
	public static void main(String[] args) {
		java.util.function.Consumer<Integer> consumer = intger -> System.out.println(intger);//or System.out::println

		consumer.accept(55);
		consumer.andThen(consumer).accept(345);


		BiConsumer<Integer, String> consumer2 = (intger, name) -> System.out.println(intger + " of " + name); //not convertible to Method Refrence as arguments are modfied
		consumer2.accept(45, "Hi");
		consumer2.andThen(consumer2).accept(145, "Hioo");
	}
}
