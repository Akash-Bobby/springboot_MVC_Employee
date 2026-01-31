package com.cg.EmployeeManagementSystem_Boot_MVC.service;

import java.util.List;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;

public interface Employee_Service {
	
	public Employee get_byid(long id);
	
	public List<Employee> get_All();
	
	public void save_employee(Employee e);
	
	public Employee update(long id,Employee e);
	
	public void delete(long id);
	

}
