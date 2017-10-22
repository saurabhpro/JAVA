package udemy.saurabh.springguru201restfulfruits.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.saurabh.springguru201restfulfruits.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByFirstName(String firstName);

	void deleteByFirstName(String firstName);
}
