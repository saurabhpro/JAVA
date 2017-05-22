package pluralsight.Function;

/**
 * Created by saurabhkumar on 22/05/17.
 */
public interface Function<T, R> {
	R apply(T t);  //take something of Type T and return its content of type R
}
