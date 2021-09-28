package com.bridgelabs.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
