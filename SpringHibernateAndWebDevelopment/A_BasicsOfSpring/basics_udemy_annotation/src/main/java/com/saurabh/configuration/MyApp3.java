package saurabh.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by saurabhkumar on 02/04/17.
 */
public class MyApp3 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigMore.class);

		//default id @Component
		SwimCoach newCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(newCoach.getTraining());
		System.out.println(newCoach.getFortune());
		System.out.println(newCoach.name);

		context.close();
	}
}
