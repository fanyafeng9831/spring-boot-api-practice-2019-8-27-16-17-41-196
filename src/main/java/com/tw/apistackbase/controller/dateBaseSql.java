package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class dateBaseSql {
	private static List<Company> companies = new ArrayList<Company>();
	private static List<Employee> employees = new ArrayList<Employee>();
	static {
		
		for(int i = 1; i <= 10; i++) {
			employees.add(new Employee(i, "employee_" + i, new Random().nextInt(20), new Random().nextInt(1) % 2 == 0 ? "ÄÐ" : "Å®", new Random().nextInt(100) *1000));
		}
		for(int i = 1; i <= 3; i++) {
			companies.add(new Company(i, "alibaba_" + i, new Random().nextInt(10), employees.subList((i-1)*10,i * 10-1)));
		}
	}
	
	public List<Company> getCompanies(){
		return companies;
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}
}
