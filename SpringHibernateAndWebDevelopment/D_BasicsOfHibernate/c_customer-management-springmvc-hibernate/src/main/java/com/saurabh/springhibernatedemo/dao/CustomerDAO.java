package com.saurabh.springhibernatedemo.dao;

import com.saurabh.springhibernatedemo.entity.Customer;

import java.util.List;

/**
 * Created by saurabhkumar on 08/04/17.
 */
public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);
}
