package saurabh.configuration;

import saurabh.basicannotate.Coach;
import saurabh.basicannotate.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by saurabhkumar on 02/04/17.
 */
public class SwimCoach implements Coach {

	@Value("${foo.name}")
	String name;

	@Autowired
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getTraining() {
		return "Swim like a dolphin";
	}

	@Override
	public String getFortune() {
		return fortuneService.getDailyFortune();
	}
}
