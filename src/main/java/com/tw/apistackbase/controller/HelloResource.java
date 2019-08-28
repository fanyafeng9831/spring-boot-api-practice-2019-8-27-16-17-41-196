package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/companys")
public class HelloResource {
	List<Company> companys =new ArrayList<Company>();

	
   //获取公司列表
	@GetMapping(path="/")
	@ResponseStatus(HttpStatus.OK)
	public List<Company> companys(){
		return companys;
	}
	
    //获取某个特定的公司
	@GetMapping(path = "/001")
	 public ResponseEntity<Company> getOneEmployee(@PathVariable String id){
	  for(Company company:companys) {
	   if(company.getId().equals(id)) {
	    return ResponseEntity.ok(company);
	   }
	  }
	  return ResponseEntity.notFound().build();
	 }
	
	//添加一个公司
    @PostMapping(path="/")
	@ResponseStatus(HttpStatus.CREATED)
	public Company creatEmployee(@RequestBody Company company){
    	companys.add(company);
		return company;
	}


}
