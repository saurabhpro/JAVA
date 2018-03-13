package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

interface ApplyFilter {
	void filter(List<String> input);
}

public class FilterBobs {
	static Function<String, String> first = s ->
	{
		System.out.println(s);
		return s;
	};
	static Predicate second = t -> "bob".equalsIgnoreCase(t.toString());

	public static void main(String[] contestants) {
		final List<String> people = new ArrayList<>();
		people.add("Bob");
		people.add("bob");
		people.add("Jennifer");
		people.add("Samantha");
		final FilterBobs f = new FilterBobs();
		f.process(q -> {
			q.removeIf(second);
			//	q.forEach(first);
		}, people);
	}

	public void process(ApplyFilter a, List<String> list) {
		a.filter(list);
	}
}


class Compete {
	public static void main(String[] args) {
		Stream<Integer> is = Stream.of(8, 6, 9);
		Comparator<Integer> c = (a, b) -> b - a; // r1
		is.sorted(c).forEach(System.out::print); // r2
	}
}


