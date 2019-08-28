package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class HelloResource {
	
	@Autowired
	private dateBaseSql dbSql;
	
	//��ȡ��˾�б�
	@GetMapping("/")
	public ResponseEntity<List<Company>> getAllCompanies() {
		return ResponseEntity.ok(dbSql.getCompanies());
	}
	
	//��ȡĳ���ض��Ĺ�˾
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
		for(Company c : dbSql.getCompanies()) {
			if(c.getId() == id) {
				return ResponseEntity.ok(c);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//��ȡĳ����˾�µ�����Ա��
	@GetMapping("/{id}/employees")
	public ResponseEntity<List<Employee>> getEmployeesByCompanyId(@PathVariable int id) {
		for(Company c : dbSql.getCompanies()) {
			if(c.getId() == id) {
				return ResponseEntity.ok(c.getEmployees());
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//���һ����˾
	 @PostMapping("")
	 public ResponseEntity<List<Company>> addCompany(@RequestBody Company company){
	  dbSql.getCompanies().add(company);
	  return ResponseEntity.ok(dbSql.getCompanies());
	 }
	 
	 //����һ����˾�Ļ�����Ϣ
	 @PutMapping("/{id}")
	 public ResponseEntity<Company> updateCompany(@RequestBody Company company, @PathVariable int id){
	  for(Company c : dbSql.getCompanies()) {
	   if(c.getId() == id) {
	    c.setCompanyName(company.getCompanyName());
	    c.setEmployees(company.getEmployees());
	    c.setEmployeesNumber(company.getEmployeesNumber());
	    return ResponseEntity.ok(company);
	   }
	  }
	  return ResponseEntity.notFound().build();
	 }
	
	//ɾ��ĳ���ض��Ĺ�˾
	 @DeleteMapping("/{id}")
	 public ResponseEntity<List<Company>> deleteCompany(@PathVariable int id){
	  Iterator<Company> iterator = dbSql.getCompanies().iterator();
	  while (iterator.hasNext()) {
	   if(iterator.next().getId() == id) {
	    iterator.remove();
	    return ResponseEntity.ok(dbSql.getCompanies());
	   }
	  }
	  return ResponseEntity.notFound().build();
	 }
	 
	  //��ȡԱ������
	  @GetMapping("/")
		public ResponseEntity<List<Employee>> getAllEmployees(){
			return ResponseEntity.ok(dbSql.getEmployees());
		}
		
	    //���ĳ���ض�Ա��
		@GetMapping("/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
			for(Employee e : dbSql.getEmployees()) {
				if(e.getId() == id) {
					return ResponseEntity.ok(e);
				}
			}
			return ResponseEntity.notFound().build();
		}
		
		//��ѯ��������Ա��
		@GetMapping("/gender")
		public ResponseEntity<List<Employee>> getEmployeesByGender(@RequestParam("gender") String gender) {
			List<Employee> result = new ArrayList<Employee>();
			dbSql.getEmployees().forEach((e) -> {
				if(gender.equals(e.getGender())) {
					result.add(e);
				}
			});
			if(result.size() == 0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(result);
		}

}
