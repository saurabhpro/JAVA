package com.saurabhk15.service;

import com.saurabhk15.model.Customer;
import com.saurabhk15.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component //can also be used since it is not doing anything service like yet
@Service("customerService" /* bean name must match the searched bean name in ApplicationConfig */)
public class CustomerServiceImpl implements CustomerService {

	// Old: private CustomerRepository customerRepository = new
	// HibernateCustomerRepositoryImpl();
	// @Autowired - instance autowiring
	private CustomerRepository customerRepository;

	public CustomerServiceImpl() {

	}

	/**
	 * @param customerRepository
	 */
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("using constructor injection");
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	/**
	 * This is required if your want to have setter injection but to use this we
	 * have to auto wire service with repository (by name) using xml
	 * <property name ="instanceVariable above - customerRepository" ref = "other
	 * bean in xml- customerRepository"/>
	 * <p>
	 * autoWire="byName" needs variable name of bean to match the setter name
	 * "set"customerRepository
	 * <p>
	 * autoWire="byType" needs variable name of bean to match the setter name
	 * "set"customerRepository
	 *
	 * @param customerRepository
	 */

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("using setter injection");
		this.customerRepository = customerRepository;
	}
}
