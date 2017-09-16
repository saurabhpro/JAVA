import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saurabh.service.CustomerService;
import com.saurabh.service.CustomerServiceImpl;

public class SampleApp {

	public static void main(String[] args) {
		//Old: CustomerService service = new CustomerServiceImpl();
		
		//New : Step 1 - create context
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//maven put it to the root of app after compilation
		
		//Step 2: Make Class
		CustomerService service = applicationContext.getBean("customerService", CustomerService.class);
		//arg2 is there such that we dont have to cast the bean or suppress cast messages
		
		System.out.println(service.findAll().get(0).getFirstName());
		

	}

}
