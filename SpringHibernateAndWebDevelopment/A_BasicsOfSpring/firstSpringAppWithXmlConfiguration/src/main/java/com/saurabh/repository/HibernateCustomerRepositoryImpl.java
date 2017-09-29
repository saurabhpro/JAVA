package com.saurabh.repository;

import java.util.ArrayList;
import java.util.List;

import com.saurabh.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.saurabh.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setFirstName("Saurabh");
		customer.setLastName("Kumar");
		
		customers.add(customer);
		
		return customers;
	}
}
