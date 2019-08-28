package com.tw.apistackbase.controller;

public class Company {
	private String Id;
	private String companyName;
	
	

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

	public Company(String id, String companyName) {
		Id = id;
		this.companyName = companyName;
	}

	
	

}
