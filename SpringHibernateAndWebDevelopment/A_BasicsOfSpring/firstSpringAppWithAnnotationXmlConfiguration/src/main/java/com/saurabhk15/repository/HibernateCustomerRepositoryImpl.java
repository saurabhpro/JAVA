package com.saurabhk15.repository;

import com.saurabhk15.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.saurabhk15.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();
		customer.setFirstName("Saurabh");
		customer.setLastName("Kumar");

		customers.add(customer);

		return customers;
	}
}
