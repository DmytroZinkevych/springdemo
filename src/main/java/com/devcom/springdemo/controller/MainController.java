package com.devcom.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devcom.springdemo.entity.Department;
import com.devcom.springdemo.entity.Employee;
import com.devcom.springdemo.repository.DepartmentRepository;
import com.devcom.springdemo.repository.EmployeeRepository;

@Controller
public class MainController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public static String redirectAddress = "redirect:/";
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Department> departments = new ArrayList<Department>();
		departmentRepository.findAll().forEach(dep -> departments.add(dep));
		model.addAttribute("departments", departments);
		List<Employee> employees = employeeRepository.findAll();
		model.addAttribute("employees", employees);
		return "index";
	}
    
    @GetMapping("/seed")
    public String seedDb() {
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department("Backend Developers"));
		departments.add(new Department("Frontend Developers"));
		departments.add(new Department("Hardware Engineers"));
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Bill Gates", "Management", departments.get(0)));
		employees.add(new Employee("Navin", "Java", departments.get(0)));
		employees.add(new Employee("David", ".NET", departments.get(0)));
		employees.add(new Employee("Ivan", "Database", departments.get(0)));
		employees.add(new Employee("Andrew", "DevOps", departments.get(0)));
		employees.add(new Employee("Steve Jobs", "Management", departments.get(1)));
		employees.add(new Employee("Anna", "ML", departments.get(1)));
		employees.add(new Employee("Julia", "JavaScript", departments.get(1)));
		employees.add(new Employee("Peter", "HTML/CSS", departments.get(1)));
		employees.add(new Employee("Stephen Wozniak", "Engineer", departments.get(2)));
		employees.add(new Employee("Maria", "Hardware Engineer", departments.get(2)));
		employees.add(new Employee("Roman", "Circuits Engineer", departments.get(2)));
		employees.add(new Employee("Serhij", "Arduino", departments.get(2)));
		
		for (Department department : departments) {
			departmentRepository.save(department);
		}
		for (Employee employee : employees) {
			employeeRepository.save(employee);
		}
        return redirectAddress;
    }
}
