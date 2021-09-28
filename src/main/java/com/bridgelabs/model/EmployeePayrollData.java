package com.bridgelabs.model;

import com.bridgelabs.dto.EmployeePayrollDto;

public class EmployeePayrollData {

	private int empId;
	private String name;
	private long salary;

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(int empId, EmployeePayrollDto empDto) {
		super();
		this.empId = empId;
		this.name = empDto.name;
		this.salary = empDto.salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}
}
