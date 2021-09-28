package com.bridgelabs.service;

import java.util.List;

import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;

public interface IEmployeePayrollService {

List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollData(int id);
	
	EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp);
	
	EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto emp);
	
	void deleteEmployeePayroll(int id);
}
