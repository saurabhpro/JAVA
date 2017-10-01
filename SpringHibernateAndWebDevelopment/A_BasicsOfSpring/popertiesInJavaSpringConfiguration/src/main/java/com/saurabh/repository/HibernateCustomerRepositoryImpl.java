package com.saurabh.repository;

import com.saurabh.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepository" /* bean name */)
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	@Value("${dBUserName}")
	private String dbUserName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.saurabh.repository.CustomerRepository#findAll()
	 */
	@Override
	public List<Customer> findAll() {


		System.out.println(this.dbUserName);

		List<Customer> customers = new ArrayList<>();

		Customer customer = new Customer();
		customer.setFirstName("Saurabh");
		customer.setLastName("Kumar");

		customers.add(customer);

		return customers;
	}
}