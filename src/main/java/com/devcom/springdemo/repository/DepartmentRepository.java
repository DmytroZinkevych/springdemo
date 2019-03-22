package com.devcom.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devcom.springdemo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
/*//	@Query(value = "select e from Employee e join fetch e.department d where e.id = ?1")
	@Query(value = "SELECT Department.id, Department.depname, count(Employee.id) " + 
			"FROM Department " + 
			"LEFT JOIN Employee ON Employee.department_id = Department.id " + 
			"WHERE Department.id = ?1 " + 
			"GROUP BY Department.id",
			nativeQuery = true)
//	@Query(value = "select d, d.id, d.name, count(e.id) " + 
//			"from Department d " + 
//			"join fetch Employee e on e.department.id = d.id " + 
//			"where d.id = ?1 " + 
//			"group by d.id")
	Department findById(int id);*/
}
