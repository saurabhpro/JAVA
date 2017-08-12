import com.saurabhk15.repository.CustomerRepository;
import com.saurabhk15.repository.HibernateCustomerRepositoryImpl;
import com.saurabhk15.service.CustomerService;
import com.saurabhk15.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//declare that it is a configuration file purely written in java
@Configuration

// For Autowire :
@ComponentScan({ /* array of packages to look in */ "com.saurabhk15"})
public class AppConfig {

	// ``````````````this whole block can be removed since we Annotated both
	// Repository and Service
	// --------------those special annotations internally make them into Bean only.

	@Bean(name = "customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
		/*
		 * in the background spring handles these beans as singleton
		 */
	}

	@Bean(name = "customerService")
	public CustomerService getCustomerService() {
		/*
		 * another approach is to set using constructor as it will do the same thing, no
		 * need to write 2 lines to do one line job
		 */
		// CustomerServiceImpl service = new
		// CustomerServiceImpl(getCustomerRepository());

		CustomerServiceImpl service = new CustomerServiceImpl();
		/*
		 * setter injection is much more visible, that we first get the customer
		 * repository and then pass it to our service impl it's different from just
		 * calling setter, why ?
		 * 
		 * because as it is marked as bean, spring will now look at its context and
		 * check if that repository bean is created and inject that instance if it has
		 */
		// service.setCustomerRepository(getCustomerRepository());
		return service;
	}

	// `````````````````````````till here

}
