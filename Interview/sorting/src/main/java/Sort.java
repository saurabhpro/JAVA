import java.util.Arrays;

/**
 * Created by saurabhkumar on 09/09/17.
 */
public interface Sort {
	int[] sort(int[] ints);

	default void print(String prefix, int[] array) {
		System.out.println(prefix + " : " + Arrays.toString(array));
	}
}
