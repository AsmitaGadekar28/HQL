package com.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int EmpID;
	private String name;
	private String Domain;
	private int Salary;
	
	Employee()
	{
		
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return Domain;
	}
	public void setDomain(String domain) {
		Domain = domain;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public Employee(int empID, String name, String domain, int salary) {
		super();
		EmpID = empID;
		this.name = name;
		Domain = domain;
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EmpID=" + EmpID + ", name=" + name + ", Domain=" + Domain + ", Salary=" + Salary + "]";
	}
	


}
