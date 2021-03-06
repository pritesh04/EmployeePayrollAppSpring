package com.bridgelabs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabs.dto.EmployeePayrollDto;
import com.bridgelabs.model.EmployeePayrollData;
import com.bridgelabs.model.ResponseDto;
import com.bridgelabs.service.IEmployeePayrollService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeePayrollService service;

	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponseDto> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = service.getEmployeePayrollData();
		ResponseDto respDTO = new ResponseDto("Get call successful", empDataList);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData emp = null;
		emp = service.getEmployeePayrollData(empId);
		ResponseDto respDTO = new ResponseDto("Get call  successful", emp);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDto) {
		EmployeePayrollData emp = null;
		emp = service.addEmployeePayrollData(empPayrollDto);
		ResponseDto respDTO = new ResponseDto("created employee payroll data successful", emp);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDto empPayrollDto) {
		EmployeePayrollData emp = null;
		emp = service.updateEmployeePayrollData(1, empPayrollDto);
		ResponseDto respDTO = new ResponseDto("Updated employee payroll data successfully", emp);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

	@DeleteMapping("/get/{empId}")
	public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		service.deleteEmployeePayroll(empId);
		ResponseDto respDTO = new ResponseDto("Deleted successfully", "Deleted id = " + empId);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDto> getEmployeePayrollDataByDepartment(
			@PathVariable("department") String department) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = (List<EmployeePayrollData>) service.getEmployeeByDepartment(department);
		ResponseDto respDTO = new ResponseDto("Get call for ID Successful", empDataList);
		return new ResponseEntity<ResponseDto>(respDTO, HttpStatus.OK);
	}

}
