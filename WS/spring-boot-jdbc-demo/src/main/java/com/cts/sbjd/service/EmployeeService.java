package com.cts.sbjd.service;

import java.util.List;

import com.cts.sbjd.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(long empId);
	Employee add(Employee emp);
	Employee update(Employee emp);
	void deleteById(long empId);
}
