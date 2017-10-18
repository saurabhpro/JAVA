package saurabh.udemy.springguru101dependencyinjection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import saurabh.udemy.springguru101dependencyinjection.model.FakeDataSource;
import saurabh.udemy.springguru101dependencyinjection.model.FakeJmsBroker;

@Configuration
//@PropertySource("classpath:second.properties")
public class PropertyConfig {

	@Value("${guru.username}")
	String user;

	@Value("${guru.password}")
	String password;

	@Value("${guru.url}")
	String url;


//	@Autowired
//	Environment env;

	@Value("${guru.jms.username}")
	String jmsUsername;

	@Value("${guru.jms.password}")
	String jmsPassoword;

	@Value("${guru.jms.url}")
	String jmsUrl;


	@Bean
	public FakeDataSource getFakeDataSource() {
		FakeDataSource fk = new FakeDataSource();

		fk.setName(user);
		fk.setPassword(password);
		fk.setUrl(url);
		//env.getProperty("USERNAME", "SK");

		return fk;
	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
//		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
////		placeholderConfigurer.setLocation(new ClassPathResource("second.properties"));
//
//		return placeholderConfigurer;
//	}

	@Bean
	public FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker jmsBroker = new FakeJmsBroker();
		jmsBroker.setUsername(jmsUsername);
		jmsBroker.setPassword(jmsPassoword);
		jmsBroker.setUrl(jmsUrl);
		return jmsBroker;
	}
}

/*
Three ways to register a properties file in spring boot
1. use the setLocation() within PropertySourcesPlaceholderConfigurer
or
2. use the @PropertySource() within PropertySourcesPlaceholderConfigurer
or
3. keep everything in application.properties and no need for PropertySourcesPlaceholderConfigurer
 */
