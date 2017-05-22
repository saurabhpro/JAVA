package pluralsight.Consumer;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public class CustomConsumerRunner {
	public static void main(String[] args) {
		Consumer<Integer> consumer = new Consumer<Integer>() {
			@Override
			public void accept(Integer integer) {
				System.out.println(integer);
			}
		};

		consumer.accept(5);


		Consumer<String> stringConsumer = System.out::println;
		stringConsumer.accept("Hi");
	}
}
