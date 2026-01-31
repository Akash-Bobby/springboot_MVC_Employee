package com.cg.EmployeeManagementSystem_Boot_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;

@Repository
public interface Employee_repo extends JpaRepository<Employee, Long> {

}
