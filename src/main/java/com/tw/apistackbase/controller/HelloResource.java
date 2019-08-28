package com.tw.apistackbase.controller;

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
	
	

}
