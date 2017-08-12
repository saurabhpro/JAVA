package com.saurabhk15.service;

import com.saurabhk15.model.Customer;
import com.saurabhk15.repository.CustomerRepository;
import com.saurabhk15.repository.HibernateCustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();

	/* (non-Javadoc)
	 * @see com.saurabhk15.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
}
