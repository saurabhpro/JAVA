package pluralsight.Consumer;

/**
 * Created by saurabhkumar on 21/05/17.
 */
public interface Consumer<T> {
	void accept(T t);
}
