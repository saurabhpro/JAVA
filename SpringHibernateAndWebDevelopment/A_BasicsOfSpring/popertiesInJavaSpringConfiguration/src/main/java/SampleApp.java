import com.saurabh.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleApp {

	public static void main(String[] args) {
		// Old: CustomerService service = new CustomerServiceImpl();

		// New : Step 1 - create context
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		// Step 2: Make Class
		CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
		// arg2 is there such that we don't have to cast the bean or suppress cast
		// messages

		System.out.println(service.findAll().get(0).getFirstName());

	}

}
