package com.cts.sbjd.model;

/*
 create table emps(
  eid int primary key,
  fnm varchar(50) not null,
  sal double not null
 );
 * */

public class Employee {

	private long empId;
	private String fullName;
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(long empId, String fullName, double salary) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.salary = salary;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", salary=" + salary + "]";
	}
	
	
}
