import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.runner.JUnitCore.runClasses;

public class TestRunner {
    public static void main(String[] args) {
        Result result = runClasses(TestJunit.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}