package spring.guru;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.guru.config.PropertyConfig;
import spring.guru.model.FakeDataSource;

public class MainApplication {
	public static void main(String[] args) {

		// New : Step 1 - create context
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyConfig.class);

		// Step 2: Make Class
		FakeDataSource fakeDataSource = applicationContext.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getName());
	}
}
