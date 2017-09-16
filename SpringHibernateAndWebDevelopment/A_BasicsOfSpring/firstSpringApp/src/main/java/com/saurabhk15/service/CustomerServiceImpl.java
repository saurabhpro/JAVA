package com.saurabh.service;

import com.saurabh.model.Customer;
import com.saurabh.repository.CustomerRepository;
import com.saurabh.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();

	/* (non-Javadoc)
	 * @see com.saurabh.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
