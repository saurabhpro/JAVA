package com.saurabh.service;

import java.util.List;

import com.saurabh.model.Customer;
import com.saurabh.repository.CustomerRepository;
import com.saurabh.repository.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {

	// Old: private CustomerRepository customerRepository = new
	// HibernateCustomerRepositoryImpl();
	private CustomerRepository customerRepository;

	public CustomerServiceImpl() {
		
	}
	
	/**
	 * autoWire="constructor" needs this 
	 * @param customerRepository
	 */
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
	/**
	 * This is required if your want to have setter injection but to use this we
	 * have to auto wire service with repository (by name) using xml
	 * <property name ="instanceVariable above - customerRepository" ref = "other
	 * bean in xml- customerRepository"/>
	 * 
	 * autoWire="byName" needs variable name of bean to match the setter name "set"customerRepository
	 * 
	 * autoWire="byType" needs variable name of bean to match the setter name "set"customerRepository
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
