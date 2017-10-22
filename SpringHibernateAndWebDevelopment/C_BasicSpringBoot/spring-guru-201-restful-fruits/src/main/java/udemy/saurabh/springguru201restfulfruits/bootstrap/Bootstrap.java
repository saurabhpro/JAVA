package udemy.saurabh.springguru201restfulfruits.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import udemy.saurabh.springguru201restfulfruits.model.Category;
import udemy.saurabh.springguru201restfulfruits.model.Customer;
import udemy.saurabh.springguru201restfulfruits.repository.ICategoryRepository;
import udemy.saurabh.springguru201restfulfruits.repository.ICustomerRepository;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

	private final ICategoryRepository categoryRepository;
	private final ICustomerRepository customerRepository;

	public Bootstrap(ICategoryRepository categoryRepository, ICustomerRepository customerRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		loadCategoriesOfFruitsInRepository();

		loadCustomersInRepository();

	}

	private void loadCategoriesOfFruitsInRepository() {
		Category fruits = new Category();
		fruits.setName("Fruits");

		Category dried = new Category();
		dried.setName("Dried");

		Category fresh = new Category();
		fresh.setName("Fresh");

		Category exotic = new Category();
		exotic.setName("Exotic");

		Category nuts = new Category();
		nuts.setName("Nuts");

		categoryRepository.save(fruits);
		categoryRepository.save(dried);
		categoryRepository.save(fresh);
		categoryRepository.save(exotic);
		categoryRepository.save(nuts);

		log.debug("Data Loaded = " + categoryRepository.count());
	}

	private void loadCustomersInRepository() {
		Customer michael = new Customer();
		michael.setId(1L);
		michael.setFirstName("Michael");
		michael.setLastName("Lachappele");

		Customer customer2 = new Customer();
		customer2.setId(2L);
		customer2.setFirstName("Sam");
		customer2.setLastName("Axe");

		Customer david = new Customer();
		david.setFirstName("David");
		david.setLastName("Winter");

		Customer anne = new Customer();
		anne.setFirstName("Anne");
		anne.setLastName("Hine");

		Customer alice = new Customer();
		alice.setFirstName("Alice");
		alice.setLastName("Eastman");

		Customer micheal2 = new Customer();
		micheal2.setFirstName("Michael 2");
		micheal2.setLastName("Weston 2");

		Customer micheal3 = new Customer();
		micheal3.setFirstName("Michael 2");
		micheal3.setLastName("Weston 2");

		Customer freddy = new Customer();
		freddy.setFirstName("Freddy");
		freddy.setLastName("Meyers");

		customerRepository.save(customer2);
		customerRepository.save(michael);
		customerRepository.save(anne);
		customerRepository.save(alice);
		customerRepository.save(michael);
		customerRepository.save(micheal2);
		customerRepository.save(micheal3);
		customerRepository.save(freddy);


		log.debug("Data Loaded = " + customerRepository.count());
	}
}