package com.cg.EmployeeManagementSystem_Boot_MVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;
import com.cg.EmployeeManagementSystem_Boot_MVC.repository.Employee_repo;
@Service
public class Employee_service_Imp implements Employee_Service{
	@Autowired
	Employee_repo repo;

	@Override
	public Employee get_byid(long id) {
		// TODO Auto-generated method stub
		Employee e=repo.findById(id).get();
	return	e;
	}

	@Override
	public List<Employee> get_All() {
		// TODO Auto-generated method stub
	List<Employee>list=repo.findAll();
	return list;
	}

	@Override
	public void save_employee(Employee e) {
		// TODO Auto-generated method stub
		
		repo.save(e);
		
	}

	@Override
	public Employee update(long id, Employee e) {
		// TODO Auto-generated method stub
	Employee e1=repo.findById(id).get();
	e1.setName(e.getName());
	e1.setDepartment(e.getDepartment());
	e1.setEmail(e.getEmail());
	e1.setMob_num(e.getMob_num());
	
	repo.save(e1);
	
	return e1;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Employee e=repo.findById(id).get();
		
		repo.delete(e);
		
	}

}
