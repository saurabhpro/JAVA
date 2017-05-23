package pluralsight.util.Function.util.Methods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public class CollectionUtil {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(5);
		list.add(6);

		//forEach(Consumer)
		list.forEach(System.out::println);

		//removeIf(Predicate)
		boolean result = list.removeIf(i -> i == 5);
		System.out.println(result);


		//	result = list.replaceAll(c -> c==4?4:6);
		//	System.out.println(result);

		//	result =
	}
}
