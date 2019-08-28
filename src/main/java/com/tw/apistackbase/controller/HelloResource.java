package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fyf on 28/08/2017.
 */
@RestController
@RequestMapping("/companys")
public class HelloResource {
	private static List<Company> companies = new ArrayList<Company>();
	 
//	 static {
//	  List<Employee> list = new ArrayList<Employee>();
//	  for(int i = 1; i <= 200; i++) {
//	   list.add(new Employee(i, "name_" + i, i, new Random().nextInt() % 2 == 0 ? "男" : "女", new Random().nextInt(100) * 1000));
//	  }
//	  Company c = new Company(1, "中原银行", 200, list);
//	  companies.add(c);
//	 }
	 
	 @GetMapping("/companies")
	 public ResponseEntity<List<Company>> getAllCompanies() {
	  return ResponseEntity.ok(companies);
	 }
	 
	 @GetMapping("/companies/{id}")
	 public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
	  for(Company c : companies) {
	   if(c.getId() == id) {
	    return ResponseEntity.ok(c);
	   }
	  }
	  return ResponseEntity.notFound().build();
	 }
	 
	 @GetMapping("/companies/{id}/employees")
	 public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable int id) {
	  for(Company c : companies) {
	   if(c.getId() == id) {
	    return ResponseEntity.ok(c.getEmployees());
	   }
	  }
	  return ResponseEntity.notFound().build();
	 }
	 
	 @GetMapping("/companies")
	 public ResponseEntity<List<Company>> getCompaniesByPageAndPageSize(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
	  int start = (page - 1) * pageSize;
	  int end = page * pageSize;
	  if(companies.size() > 0) {
	   if(companies.size() >= start) {
	    start = 0;
	   }
	   if(companies.size() <= end) {
	    end = companies.size();
	   }
	   return ResponseEntity.ok(companies.subList(start, end));
	  }
	  return ResponseEntity.notFound().build();
	 }
	 
//	 @PostMapping("/companies")
//	 public ResponseEntity<List<Company>> addCompany(@RequestBody Company company){
//	  companies.add(company);
//	  return 
//	 }

	}