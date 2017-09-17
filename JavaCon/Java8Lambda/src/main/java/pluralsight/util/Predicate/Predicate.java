package pluralsight.util.Predicate;

/**
 * Created by saurabhkumar on 21/05/17.
 */

@FunctionalInterface    //only one ABSTRACT method
public interface Predicate<T> {
	static <U> Predicate<U> isEqualsTo(U u) {
		return s -> s.equals(u);
	}

	boolean test(T t);

	default Predicate<T> and(Predicate<T> other) {
		return t -> test(t) && other.test(t);
	}

	default Predicate<T> or(Predicate<T> other) {
		return t -> test(t) || other.test(t);
	}
}
