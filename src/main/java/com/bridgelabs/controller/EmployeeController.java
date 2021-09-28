package com.bridgelabs.controller;

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

@RestController
public class EmployeeController {
	
	@GetMapping("/get")
	public String hello()
	{
		return "HEllo";
	}
	@PostMapping("/post")
	public String helloPost()
	{
		return "HEllo";
	}
	@PutMapping("/put")
	public String helloPut()
	{
		return "HEllo";
	}
	@DeleteMapping("/delete")
	public String helloDelete()
	{
		return "HEllo";
	}
	
	 @RequestMapping(value={"/get"})
     public ResponseEntity<ResponseDto> getEmployeePayrollData()
     {
    	 EmployeePayrollData emp=null;
    	 emp=new EmployeePayrollData(1,new EmployeePayrollDto("pritesh",2000));
    	 ResponseDto respDTO=new ResponseDto("Get call successful",emp);
    	 return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
     }
     
     @GetMapping("/get/{empId}")
     public ResponseEntity<ResponseDto> getEmployeePayrollData(@PathVariable("empId") int empId)
     {
    	 EmployeePayrollData emp=null;
    	 emp=new EmployeePayrollData(1,new EmployeePayrollDto("Pritesh",2000));
    	 ResponseDto respDTO=new ResponseDto("Get call successful",emp);
    	 return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
     }
     
     @PostMapping("/create")
     public ResponseEntity<ResponseDto> addEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
     {
    	 EmployeePayrollData emp=null;
    	 emp=new EmployeePayrollData(1,empPayrollDto);
    	 ResponseDto respDTO=new ResponseDto("created employee payroll data successful",emp);
    	 return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
     }
     
     @PutMapping("/update")
     public ResponseEntity<ResponseDto> updateEmployeePayrollData(@RequestBody EmployeePayrollDto empPayrollDto)
     {
    	 EmployeePayrollData emp=null;
    	 emp=new EmployeePayrollData(1,empPayrollDto);
    	 ResponseDto respDTO=new ResponseDto("Updated employee payroll data successfully",emp);
    	 return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
     }
     
     @DeleteMapping("/get/{empId}")
     public ResponseEntity<ResponseDto> deleteEmployeePayrollData(@PathVariable("empId") int empId)
     {
    	 ResponseDto respDTO=new ResponseDto("Deleted successfully","Deleted id = "+empId);
    	 return new ResponseEntity<ResponseDto>(respDTO,HttpStatus.OK);
     }
}
