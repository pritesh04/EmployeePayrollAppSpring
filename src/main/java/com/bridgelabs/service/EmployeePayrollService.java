package com.bridgelabs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bridgelabs.advice.EmployeePayrollException;
import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;
import com.bridgelabs.model.ResponseDto;
import com.bridgelabs.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {
	@Autowired
	  EmployeeRepository employeeRepository;

	private List<EmployeePayrollData> list = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		return employeeRepository.findById(empId).orElseThrow(
				() -> new EmployeePayrollException("Employee with employeeId " + empId + " does not exists..."));
	}

	@Override
	public EmployeePayrollData addEmployeePayrollData(EmployeePayrollDto emp) {
		EmployeePayrollData data = new EmployeePayrollData(emp);
		log.debug("Emp Data :" + data.toString());
		return employeeRepository.save(data);
	}

	@Override
	public void deleteEmployeePayroll(int empId) {
		EmployeePayrollData empData = this.getEmployeePayrollData(empId);
		employeeRepository.delete(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDto emp) {
		EmployeePayrollData data = this.getEmployeePayrollData(empId);
		data.updateEmployeePayrollData(emp);
		return employeeRepository.save(data);
	}

	@Override
	public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
		return employeeRepository.findEmployeeByDepartment(department);
	}

	
}
