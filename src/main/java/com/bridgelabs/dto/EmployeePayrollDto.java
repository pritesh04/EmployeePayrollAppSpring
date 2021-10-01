package com.bridgelabs.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
public @ToString class EmployeePayrollDto {

	@Pattern(regexp = "^[A-Z]{1}{a-zA-Z\\s}{2,}$", message = "Employee name is invalid")
	public String name;

	@Min(value = 500, message = "Min wage should above 500")
	public long salary;

	@Pattern(regexp = "male|female", message = "Gender Should be Male female")
	public String gender;

	@JsonFormat(pattern = "dd MM yyyy")
	@NotNull(message = "Start date should not be empty")
	@PastOrPresent(message = "Start date should be past or today")
	public LocalDate startDate;

	@NotBlank(message = "Note can not be empty")
	public String note;

	@NotBlank(message = "Profile pic can not be empty")
	public String profilePic;

	@NotBlank(message = "Department should not be empty")
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
