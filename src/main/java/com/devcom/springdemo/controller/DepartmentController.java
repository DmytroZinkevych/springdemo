package com.devcom.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devcom.springdemo.entity.Department;
import com.devcom.springdemo.repository.DepartmentRepository;

@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/create")
	public String createDepartmentGet() {
		return "create-department";
	}
	
	@PostMapping("/create")
	public String createDepartmentPost(
			@RequestParam(name = "name", required = true) String name,
			Model model) {
		departmentRepository.save(new Department(name));
		return MainController.redirectAddress;
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editDepartmentByIdGet(@PathVariable("id") int id, Model model) {
		if (!departmentRepository.existsById(id)) {
			return "error";
		}
		model.addAttribute("department", departmentRepository.findById(id).get());
		return "edit-department";
	}
	
	@PostMapping(value = "/edit")
	public String editDepartmentByIdPost(
			@RequestParam(name = "id", required = true) int id,
			@RequestParam(name = "name", required = true) String name) {
		if (!departmentRepository.existsById(id)) {
			return "error";
		}
		Department department = departmentRepository.findById(id).get();
		department.setName(name);
		departmentRepository.save(department);
		return MainController.redirectAddress;
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteDepartment(@PathVariable("id") int id) {
		if (!departmentRepository.existsById(id)) {
			return "error";
		}
		departmentRepository.deleteById(id);
		return MainController.redirectAddress;
	}
}
