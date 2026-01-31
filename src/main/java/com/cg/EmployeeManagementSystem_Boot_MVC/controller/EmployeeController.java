package com.cg.EmployeeManagementSystem_Boot_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.EmployeeManagementSystem_Boot_MVC.entity.Employee;
import com.cg.EmployeeManagementSystem_Boot_MVC.service.Employee_Service;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	Employee_Service service;
	@GetMapping()
	public String listEmployee(Model model) {
		model.addAttribute("list", service.get_All());
		
		return "employees";
	}
	
	@GetMapping("/add")
	public String addEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		
		return "employee-form";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute ("employee") Employee emp) {
		
		service.save_employee(emp);
		
		return "redirect:/employees";
		
	}
	
	@GetMapping("/edit/{id}")
	public String getedit_EmpolyeeForm(@PathVariable long id,Model model) {
		model.addAttribute("employee", service.get_byid(id));
		
		return "employee-form";
	}
	
	@PostMapping("/update/{id}")
	public String editemployee(@PathVariable long id,@ModelAttribute Employee emp) {
		
		service.update(id, emp);
		return "redirect:/employees";
	}
	@GetMapping("/delete/{id}")
	public String deleteemployee(@PathVariable long id ) {
		
		service.delete(id);
		
		return "redirect:/employees";
		
	}

}
