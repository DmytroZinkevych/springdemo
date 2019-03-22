package com.devcom.springdemo.entity;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.devcom.springdemo.entity.Employee;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "depname") // department_name
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY /*FetchType.EAGER*/, mappedBy = "department"/*, cascade = {CascadeType.PERSIST, CascadeType.MERGE}*/, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.TRUE /*LazyCollectionOption.FALSE*/)
//	@Fetch(FetchMode.SELECT)
	private List<Employee> employees;

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
