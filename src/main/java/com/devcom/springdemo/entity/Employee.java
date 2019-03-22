package com.devcom.springdemo.entity;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.hibernate.annotations.Fetch;
//import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.devcom.springdemo.entity.Department;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "empname") // employee_name
	private String name;

	@Column(name = "skill")
	private String skill;

	@ManyToOne(fetch = FetchType.LAZY/*, cascade = CascadeType.PERSIST*/)
	@JoinColumn(name = "department_id")
	@LazyCollection(LazyCollectionOption.TRUE)
//	@Fetch(FetchMode.SELECT)
	private Department department;

	protected Employee() {}

	public Employee(String empname, String skill, Department department) {
		this.name = empname;
		this.skill = skill;
		this.department = department;
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee(int id, String name, String skill) {
		this.id = id;
		this.name = name;
		this.skill = skill;
	}

	public Employee(int id, String name, String skill, Department department) {
		this.id = id;
		this.name = name;
		this.skill = skill;
		this.department = department;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skill=" + skill /*+ ", department=" + department.getName()*/ + "]";
	}
}
