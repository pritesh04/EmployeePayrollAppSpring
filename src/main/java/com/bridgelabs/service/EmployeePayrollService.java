package com.bridgelabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

	private List<EmployeePayrollData> empList=new ArrayList<>();
	
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return empList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		return empList.get(empId-1);
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data;
		data=new EmployeePayrollData(empList.size()+1,emp);
		empList.add(data);
		return data;
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		empList.remove(empId-1);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto emp) {
		EmployeePayrollData data=this.getEmployeePayrollData(empId);
		data.setName(emp.getName());
		data.setSalary(emp.getSalary());
		empList.set(empId-1, data);
		return data;
	}

	
}
