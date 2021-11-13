import java.util.List;

public class ForEachY {
    public static void main(String[] args) {
        List<String> t = null;

        for (String o : t) {
            System.out.println("hey");
        }

        t.stream().forEach((c) -> System.out.println("hey"));
    }
}
