package methodReference.constructorEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by saurabhkumar on 23/05/17.
 */
public class WithoutArgument {
	public static void main(String[] args) {
		// Using an anonymous class
		Supplier<List<String>> s = new Supplier() {
			public List<String> get() {
				return new ArrayList<>();
			}
		};
		List<String> l = s.get();


		// Using a lambda expression
		Supplier<List<String>> s2 = () -> new ArrayList<>();
		List<String> l2 = s.get();


		// Using a method reference
		Supplier<List<String>> s3 = ArrayList::new;
		List<String> l3 = s.get();
	}
}
