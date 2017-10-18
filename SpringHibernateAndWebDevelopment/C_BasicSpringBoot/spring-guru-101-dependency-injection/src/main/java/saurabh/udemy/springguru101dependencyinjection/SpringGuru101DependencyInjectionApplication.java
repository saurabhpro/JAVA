package saurabh.udemy.springguru101dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import saurabh.udemy.springguru101dependencyinjection.model.FakeDataSource;
import saurabh.udemy.springguru101dependencyinjection.model.FakeJmsBroker;

@SpringBootApplication
public class SpringGuru101DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringGuru101DependencyInjectionApplication.class, args);

//		MyController controller = (MyController) ctx.getBean("myController");
//
//		controller.sayHello();
//
//		System.out.println(controller.sayHello());
//
//		// Marking of Spring bean is required since then only we can use it here
//		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
//		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
//		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());

		// Step 2: Make Class
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);

		System.out.println(fakeDataSource.getName());

		FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUsername());
	}
}
