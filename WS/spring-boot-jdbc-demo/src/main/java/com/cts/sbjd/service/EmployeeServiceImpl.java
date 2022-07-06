package com.cts.sbjd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbjd.model.Employee;
import com.cts.sbjd.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findById(long empId) {
		return empRepo.findById(empId);
	}

	@Override
	public Employee add(Employee emp) {
		return empRepo.add(emp);
	}

	@Override
	public Employee update(Employee emp) {
		return empRepo.update(emp);
	}

	@Override
	public void deleteById(long empId) {
		empRepo.deleteById(empId);

	}

}
