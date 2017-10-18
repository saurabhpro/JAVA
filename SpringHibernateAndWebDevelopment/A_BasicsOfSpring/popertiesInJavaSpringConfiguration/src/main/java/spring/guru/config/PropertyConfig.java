package spring.guru.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import spring.guru.model.FakeDataSource;

@Configuration
@PropertySource("classpath:second.properties")
public class PropertyConfig {

	@Value("${guru.username}")
	String user;

	@Value("${guru.password}")
	String password;

	@Value("${guru.url}")
	String url;


	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fk = new FakeDataSource();

		fk.setName(user);
		fk.setPassword(password);
		fk.setUrl(url);

		return fk;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
