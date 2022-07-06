package com.cts.sbjd.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.sbjd.model.Employee;
import com.cts.sbjd.service.EmployeeService;

@Component
public class EmployeeUI implements CommandLineRunner{

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private Scanner scan;
	
	@Override
	public void run(String... args) throws Exception {
		Menu menu = null;
		while(menu!=Menu.QUIT) {
			for(Menu m : Menu.values()) {
				System.out.println(m.ordinal()+"\t"+m);
			}
			System.out.println("Choice: ");
			int choice = scan.nextInt();
			
			menu = Menu.values()[choice];
			
			switch(menu) {
			case LIST: doList(); break;
			case ADD:doAdd(); break;
			case DELETE:doDelete();break;
			case QUIT: System.out.println("App Termninated"); break;
			}
		}
		
	}
	
	private void doList() {
		List<Employee> emps = empService.findAll();
		
		if(emps==null || emps.isEmpty()) {
			System.out.println("No records");
		}else {
			emps.stream().forEach(System.out::println);
		}
	}
	
	private void doAdd() {
		System.out.print("EmpID: ");
		long empId = scan.nextLong();
		System.out.print("Full Name: ");
		String fullName=scan.next();
		System.out.print("Salary: ");
		double salary = scan.nextDouble();
		
		empService.add(new Employee(empId, fullName, salary));
		System.out.println("Record Saved");
	}
	
	private void doDelete() {
		System.out.print("EmpID: ");
		long empId = scan.nextLong();
		empService.deleteById(empId);
		System.out.println("Record Deleted");
	}
}
