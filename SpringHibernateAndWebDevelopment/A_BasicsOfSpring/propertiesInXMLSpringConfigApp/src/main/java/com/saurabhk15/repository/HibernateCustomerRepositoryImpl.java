package com.saurabh.repository;

import com.saurabh.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("CustomerRepository" /*bean name*/)
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	private String dbUserName;

	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}

	/* (non-Javadoc)
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
