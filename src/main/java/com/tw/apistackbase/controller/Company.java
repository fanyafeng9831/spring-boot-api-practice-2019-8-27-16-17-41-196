package com.tw.apistackbase.controller;

import java.util.List;

public class Company {
	private String Id;
	private String companyName;
	private int employeesNumber;
	private List<Employee> employees;
	
	

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(String id, String companyName, int employeesNumber, List<Employee> employees) {
		super();
		Id = id;
		this.companyName = companyName;
		this.employeesNumber = employeesNumber;
		this.employees = employees;
	}


	
	

}
