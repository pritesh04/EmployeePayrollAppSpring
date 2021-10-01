package com.bridgelabs.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabs.dto.EmployeePayrollDto;

import ch.qos.logback.core.subst.Token.Type;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "employee_payroll")
@Data
public @NoArgsConstructor class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_id")
	private int empId;
	@Column(name="name")
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns=@JoinColumn(name="id"))
	@Column(name="department")
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
