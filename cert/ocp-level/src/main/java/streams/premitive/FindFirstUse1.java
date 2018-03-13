package streams.premitive;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FindFirstUse1 {
	public static void main(String[] args) {
		Method[] methods = Stream.class.getMethods();

		Optional<String> methodName = Arrays.stream(methods)
				.map(method -> method.getName())
				.filter(name -> name.endsWith("Match"))
				.sorted()
				.findFirst();

		System.out.println("Result: " + methodName.orElse("No suitable method found"));
	}
}

class FindFirstUse2 {
	public static void main(String[] args) {
		OptionalDouble temperature = DoubleStream.of(-10.1, -5.4, 6.0, -3.4, 8.9, 2.2)
				.filter(temp -> temp > 0)
				.findFirst();
		System.out.println("First matching temperature > 0 is " + temperature.getAsDouble());
	}
}
