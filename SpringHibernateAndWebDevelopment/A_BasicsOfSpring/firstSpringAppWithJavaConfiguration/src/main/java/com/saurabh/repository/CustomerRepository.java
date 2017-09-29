package com.saurabh.repository;

import com.saurabh.model.Customer;

import java.util.List;

public interface CustomerRepository {

	List<Customer> findAll();

}