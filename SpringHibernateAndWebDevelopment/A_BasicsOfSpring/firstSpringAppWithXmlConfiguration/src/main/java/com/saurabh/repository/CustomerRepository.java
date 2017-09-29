package com.saurabh.repository;

import java.util.List;

import com.saurabh.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}