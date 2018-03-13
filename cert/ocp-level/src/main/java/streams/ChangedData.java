package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChangedData {
	public static void main(String[] args) {
		List<String> cats = new ArrayList<>();
		cats.add("Annie");
		cats.add("Ripley");

		Stream<String> stream = cats.stream();
		cats.add("KC");

		// Remember that streams are lazily evaluated. This means that the stream isn’t actually created above.
		System.out.println(stream.count()); // the stream pipeline actually runs, hence 3
	}
}
