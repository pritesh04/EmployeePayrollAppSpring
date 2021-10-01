package com.bridgelabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabs.advice.EmployeePayrollException;
import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;
import com.bridgelabs.repository.EmployeeRepository;
@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	EmployeeRepository employeeRepository;
	
	private List<EmployeePayrollData> list=new ArrayList<>();
	
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return list;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		return list.stream().filter(empData->empData.getEmpId()==empId).findFirst().orElseThrow(()->new EmployeePayrollException("Employee not found"));
		//return list.get(empId-1);
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data;
		data=new EmployeePayrollData(list.size()+1,emp);
		list.add(data);
		return data;
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		list.remove(empId-1);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto emp) {
		EmployeePayrollData data=this.getEmployeePayrollData(empId);
		data.setName(emp.getName());
		data.setSalary(emp.getSalary());
		list.set(empId-1, data);
		return data;
	}

	

}
