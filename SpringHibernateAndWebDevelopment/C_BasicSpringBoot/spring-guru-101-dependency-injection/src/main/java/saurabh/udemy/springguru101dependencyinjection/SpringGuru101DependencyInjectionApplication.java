package saurabh.udemy.springguru101dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import saurabh.udemy.springguru101dependencyinjection.controllers.ConstructorInjectedController;
import saurabh.udemy.springguru101dependencyinjection.controllers.MyController;
import saurabh.udemy.springguru101dependencyinjection.controllers.PropertyInjectedController;
import saurabh.udemy.springguru101dependencyinjection.controllers.SetterInjectedController;

@SpringBootApplication
public class SpringGuru101DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringGuru101DependencyInjectionApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		controller.sayHello();

		System.out.println(controller.sayHello());

		// Marking of Spring bean is required since then only we can use it here
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}
