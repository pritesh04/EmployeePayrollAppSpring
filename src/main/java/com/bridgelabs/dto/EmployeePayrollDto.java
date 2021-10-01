package com.bridgelabs.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@Data
public @ToString class EmployeePayrollDto {

	@Pattern(regexp="^[A-Z]{1}{a-zA-Z\\s}{2,}$",message="Employee name is invalid")
	public String name;
	@Min(value=500,message="Min wage should above 500")
	public long salary;
	
	public String gender;
	
	public String startDate;
	
	public String note;
	
	public String profilePic;
	
	public List<String> department;


	public EmployeePayrollDto(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	



	@Override
	public String toString() {
		return "EmployeePayrollDto [name=" + name + ", salary=" + salary + "]";
	}
}
