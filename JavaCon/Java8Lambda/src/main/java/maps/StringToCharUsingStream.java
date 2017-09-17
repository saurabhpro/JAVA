package maps;

import java.util.stream.Stream;

public class StringToCharUsingStream {

	public static void main(String[] args) {

		String password = "password123";

		//approach 1
		char[] passwordInCharArray = password.toCharArray();

		Stream<Character> c = password.chars() //IntStream
				.mapToObj(x -> (char) x);//Stream<Character>
//                .forEach(System.out::println);

		c.forEach(System.out::println);
	}

}