package com.devcom.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devcom.springdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
//	Employee findByName(String name);
	
	@Query(value = "select e from Employee e join fetch e.department d where e.id = ?1")
	Employee findWithDepNameById(int id);
	
//	@Query(value = "select * from Employee e where e.id = ?1", nativeQuery = true)
//	Employee findByIdNativeQuery(int id);

}
