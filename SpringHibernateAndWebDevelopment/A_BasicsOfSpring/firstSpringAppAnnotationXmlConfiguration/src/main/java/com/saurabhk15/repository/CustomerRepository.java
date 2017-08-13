package com.saurabhk15.repository;

import com.saurabhk15.model.Customer;

import java.util.List;

public interface CustomerRepository {

	List<Customer> findAll();

}