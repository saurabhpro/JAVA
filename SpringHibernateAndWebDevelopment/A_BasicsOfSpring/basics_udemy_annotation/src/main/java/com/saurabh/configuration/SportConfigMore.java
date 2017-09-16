package saurabh.configuration;

import saurabh.basicannotate.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by saurabhkumar on 02/04/17.
 */
@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfigMore {

	//method name will be our bean id
	@Bean
	public FortuneService sadFortuneService(){
		return new SadFortuneService();
	}

	@Bean
	public SwimCoach swimCoach(){
		return new SwimCoach(sadFortuneService());
	}
}
