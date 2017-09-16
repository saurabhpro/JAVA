package saurabh.configuration;

import saurabh.basicannotate.Coach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by saurabhkumar on 02/04/17.
 */
public class MyApp2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfigBasic.class);

		//default id @Component
		Coach newCoach = context.getBean("swimCoach", Coach.class);
		System.out.println(newCoach.getTraining());
		System.out.println(newCoach.getFortune());

		context.close();
	}
}
