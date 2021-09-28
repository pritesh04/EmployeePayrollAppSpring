package com.bridgelabs.service;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;

public class EmployeePayrollService implements IEmployeePayrollService {
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
	     List<EmployeePayrollData> list=new ArrayList<>();
	     list.add(new EmployeePayrollData(1,new EmployeePayrollDto("Pritesh",3000)));
		return list;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int id) {
		  EmployeePayrollData emp;
	     emp = new EmployeePayrollData(1,new EmployeePayrollDto("Pritesh",3000));
		return emp;
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data;
		data=new EmployeePayrollData(1,emp);
		return data;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data;
		data=new EmployeePayrollData(1,emp);
		return data;
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		
	}
}
