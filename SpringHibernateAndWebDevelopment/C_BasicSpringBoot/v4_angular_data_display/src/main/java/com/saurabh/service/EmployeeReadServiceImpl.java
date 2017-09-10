package com.saurabh.service;

import com.saurabh.entity.AllEmpDetails;
import com.saurabh.repository.MockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by saurabhkumar on 09/09/17.
 */
@Service
public class EmployeeReadServiceImpl implements EmployeeReadService {

	private final MockRepository mockRepository;

	@Autowired
	EmployeeReadServiceImpl(MockRepository mockRepository) {
		this.mockRepository = mockRepository;
	}

	@Override
	public AllEmpDetails getEmployeeDetails() {
		return mockRepository.getEmployeeDetails();
	}
}
