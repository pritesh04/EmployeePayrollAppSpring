package com.bridgelabs.model;

import java.util.List;

import com.bridgelabs.dto.EmployeePayrollDto;

import lombok.NoArgsConstructor;

public @NoArgsConstructor class EmployeePayrollData {
	private int empId;
	private String name;
	private long salary;
	private String gender;
	private String startDate;
	private String note;
	private String profilePic;
	private List<String> deparment;
	

	public EmployeePayrollData(int empId, EmployeePayrollDto empPayrollDTO) {
		super();
		this.empId = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.profilePic = empPayrollDTO.profilePic;
		this.deparment = empPayrollDTO.department;
	}

}
