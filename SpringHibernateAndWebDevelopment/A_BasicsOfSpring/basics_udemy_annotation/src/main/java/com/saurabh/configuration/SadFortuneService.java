package com.saurabh.configuration;

import com.saurabh.basicannotate.FortuneService;
import org.springframework.stereotype.Component;

/**
 * Created by saurabhkumar on 02/04/17.
 */
@Component
public class SadFortuneService implements FortuneService {
	@Override
	public String getDailyFortune() {
		return "Today was a sad day";
	}
}
