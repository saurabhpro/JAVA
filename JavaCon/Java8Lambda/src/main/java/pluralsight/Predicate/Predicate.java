package pluralsight.Predicate;

/**
 * Created by saurabhkumar on 21/05/17.
 */

@FunctionalInterface    //only one ABSTRACT method
public interface Predicate<T> {
	boolean test(T t);
}
