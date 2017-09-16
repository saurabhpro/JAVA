package saurabh.basicannotate;

import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 02/04/17.
 */
@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
}
