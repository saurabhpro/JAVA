package saurabh.configuration;

import saurabh.basicannotate.FortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by saurabhkumar on 02/04/17.
 */

@Configuration
@ComponentScan("com.saurabh.basicannotate")
public class SportConfigBasic {

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
