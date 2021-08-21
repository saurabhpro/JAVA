package pluralsight.util.util.Methods;

import pluralsight.util.common.Person;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);

        List<Person> list = List.of(p1, p2, p3, p4, p5, p6);

        long limit = 3;
        long toSkip = 2;

        // with lambdas
        list.stream()
                .skip(toSkip)
                .filter(p -> p.getAge() > 30)
                .limit(limit)
                .forEach(System.out::println);

        // without lambda
        for (Person p : list) {
            if (toSkip > 0) {
                toSkip--;
                continue;
            }
            if (limit-- == 0) break;
            if (p.getAge() > 30) {
                System.out.println(p);
            }
        }
    }
}
