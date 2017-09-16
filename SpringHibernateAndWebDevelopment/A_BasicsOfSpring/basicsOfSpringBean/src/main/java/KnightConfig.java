import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by saurabhkumar on 09/09/17.
 */

@Configuration
public class KnightConfig {

	@Bean
	public Knight getKnight() {
		return new MajesticKnight();
	}

	@PostConstruct
	public void init(){
		System.out.println("init from config");
	}

	@PreDestroy
	public void preDestroy(){
		System.out.println("destroy from config");
	}
}
