package com.devcom.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devcom.springdemo.entity.Department;
import com.devcom.springdemo.entity.Employee;
import com.devcom.springdemo.repository.DepartmentRepository;
import com.devcom.springdemo.repository.EmployeeRepository;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	private List<Department> getDepartmentNameAndIdList(Model model) {
		List<Department> departments = new ArrayList<Department>();
		departmentRepository.findAll().forEach((dep) -> departments.add(dep));
		return departments;
	}
	
	@GetMapping("/create")
	public String createEmployeeGet(Model model) {
		model.addAttribute("departments", getDepartmentNameAndIdList(model));
		return "create-employee";
	}
	 
	@PostMapping("/create")
	public String createEmployeePost(
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "skill", required = true) String skill,
			@RequestParam(name = "department_id", required = true) int department_id) {
		Department department = departmentRepository.findById(department_id).get();
		Employee employee = new Employee(name, skill, department);
		employeeRepository.save(employee);
		return MainController.redirectAddress;
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployeeGet(@PathVariable("id") int id, Model model) {
		if (!employeeRepository.existsById(id)) {
			return "error";
		}
		model.addAttribute("employee", employeeRepository.findById(id).get());
		model.addAttribute("departments", getDepartmentNameAndIdList(model));
		return "edit-employee";
	}
	
	@PostMapping("/edit")
	public String editEmployeePost(
			@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "skill", required = true) String skill,
			@RequestParam(name = "department_id", required = true) int department_id) {
		if (!employeeRepository.existsById(id)) {
			return "error";
		}
		Department department = departmentRepository.findById(department_id).get();
		Employee employee = employeeRepository.findById(id).get();
		employee.setName(name);
		employee.setSkill(skill);
		employee.setDepartment(department);
		employeeRepository.save(employee);
		return MainController.redirectAddress;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		if (!employeeRepository.existsById(id)) {
			return "error";
		}
		employeeRepository.delete(employeeRepository.findById(id).get());
		return MainController.redirectAddress;
	}

}
