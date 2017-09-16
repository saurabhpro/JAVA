package com.saurabh.basicannotate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by saurabhkumar on 02/04/17.
 */

@Component("basicId")
@Scope("singleton")
public class TennisCoach implements Coach {

	//not recommended by spring team
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Value("${foo.name}")
	String name;
	@Value("${foo.call}")
	String callWho;

	public String getName() {
		return name;
	}

	public String getCallWho() {
		return callWho;
	}

	@Override
	public String getTraining() {
		return "Nadal se kuch sikho";
	}

	@Override
	public String getFortune() {
		return fortuneService.getDailyFortune();
	}

	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
	}

	// define my destroy method
	//For "prototype" scoped beans, Spring does not call the @PreDestroy method.
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}
}
