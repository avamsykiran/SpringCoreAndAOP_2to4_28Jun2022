package com.cts.sbjd.repo;

import java.util.List;

import com.cts.sbjd.model.Employee;

public interface EmployeeRepo {
	
	List<Employee> findAll();
	Employee findById(long empId);
	Employee add(Employee emp);
	Employee update(Employee emp);
	void deleteById(long empId);

}
