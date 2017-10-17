package com.saurabh.v2attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeBasicRecord extends CrudRepository<EmployeeBasicRecord, String> {
}
