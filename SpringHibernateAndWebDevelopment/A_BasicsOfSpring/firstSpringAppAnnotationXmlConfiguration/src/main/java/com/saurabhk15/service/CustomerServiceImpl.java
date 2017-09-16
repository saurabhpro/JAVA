package com.saurabh.service;

import com.saurabh.model.Customer;
import com.saurabh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService" /*bean name*/)
public class CustomerServiceImpl implements CustomerService {

	// Old: private CustomerRepository customerRepository = new
	// HibernateCustomerRepositoryImpl();
	private CustomerRepository customerRepository;

	public CustomerServiceImpl() {

	}

	/**
	 * @param customerRepository
	 */
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("We are using constructor injection");

		this.customerRepository = customerRepository;
	}


	/**
	 * This is required if your want to have setter injection but to use this we
	 * have to auto wire service with repository (by name) using xml
	 * <property name ="instanceVariable above - customerRepository" ref = "other
	 * bean in xml- customerRepository"/>
	 * <p>
	 * autoWire="byName" needs variable name of bean to match the setter name "set"customerRepository
	 * <p>
	 * autoWire="byType" needs variable type of bean to match the setter name "set"customerRepository
	 *
	 * @param customerRepository
	 */
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
