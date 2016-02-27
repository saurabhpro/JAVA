import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Saurabh on 2/28/2016.
 */
public class SingletonCollection {
    public static void main(String[] args) {
        List<Integer> list = Collections.singletonList(45);
        Set<Integer> set = Collections.singleton(46);
        Map<Integer, String> map = Collections.singletonMap(47, "Hey");

        list.stream().forEach(System.out::println);
        set.stream().forEach(System.out::println);

    }
}
