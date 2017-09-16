package com.saurabh.basicannotate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by saurabhkumar on 02/04/17.
 */
@Component
@Scope("prototype")
public class ChessCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	ChessCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		System.out.println("Inside ChessCoach Constructor");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getTraining() {
		return "Chess Yay";
	}

	@Override
	public String getFortune() {
		return fortuneService.getDailyFortune();
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside ChessCoach setter");
		this.fortuneService = fortuneService;
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void makeFortuneService(FortuneService fortuneService) {
		System.out.println("Inside ChessCoach General Method");
		this.fortuneService = fortuneService;
	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> ChessCoach: inside of doMyStartupStuff()");
	}

	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> ChessCoach: inside of doMyCleanupStuff()");
	}

}
