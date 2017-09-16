package com.saurabh.basicannotate;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 02/04/17.
 */
public class MyApp1 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appConfig.xml");

		//using our specified id @Component ("basicId")
		TennisCoach coach = context.getBean("basicId", TennisCoach.class);
		System.out.println(coach.getTraining());
		System.out.println(coach.getFortune());
		System.out.println(coach.getCallWho());
		System.out.println(coach.getName());

		//default id @Component
		Coach newCoach = context.getBean("chessCoach", Coach.class);
		System.out.println(newCoach.getTraining());
		System.out.println(newCoach.getFortune());

		context.close();
	}
}
