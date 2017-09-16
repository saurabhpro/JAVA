package com.saurabh.springhibernatedemo.service;

import com.saurabh.springhibernatedemo.dao.CustomerDAO;
import com.saurabh.springhibernatedemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao here now
	private final CustomerDAO customerDAO;

	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//simply delegate call to customerDAO
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		//simply delegate call to customerDAO
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	/*
	if this @transactional is nit defined we get
	org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thread
	*/
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
	}
}





