package com.saurabhk15.repository;

import java.util.List;

import com.saurabhk15.model.Customer;

public interface CustomerRepository {

	List<Customer> findAll();

}