import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by saurabhkumar on 12/02/17.
 */
public class PrintCommaList {

    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Ram", "Shyam", "Sita", "Gita");

        System.out.println(
                nameList.stream()
                        .map(String::toUpperCase)
                        .collect(joining(", ")));
    }
}
