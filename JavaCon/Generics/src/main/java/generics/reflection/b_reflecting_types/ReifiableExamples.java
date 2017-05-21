package generics.reflection.b_reflecting_types;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ReifiableExamples {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ReifiableExamples.class);
		BasicConfigurator.configure();
		logger.info("This is my first log4j's statement");

		System.out.println(int.class);

		System.out.println(String.class);

		List<?> wildcards = new ArrayList<>();
		System.out.println(wildcards.getClass());

		List raw = new ArrayList();
		System.out.println(raw.getClass());

		System.out.println(raw.getClass() == wildcards.getClass());

		System.out.println(int[].class);
		System.out.println(List[].class);
	}
}
